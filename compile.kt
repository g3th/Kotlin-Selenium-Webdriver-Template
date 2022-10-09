import java.io.File
import java.nio.file.Paths


fun main(){
	print("Enter project name (no extension, i.e. 'project' not 'project.kt'): ")
	var projectName:String? = readLine()
	var currentDirectory = Paths.get("").toAbsolutePath().toString()
	var dependenciesDirectory = currentDirectory + "/libs/"
	var tempDirectory = currentDirectory + "/temp/"
	var jarList:List<String> = emptyList()
	
	File(tempDirectory).mkdir()
	File(dependenciesDirectory).walk().forEach {
		if (".jar" in it.toString()){
			jarList = jarList.plus(it.toString())
		}
	}
	
	var counter:Int = 0
	var classPath:String = ""
	for (jar in jarList){
		classPath = classPath.plus(jar + ":")
		++ counter
		if (counter == jarList.size){
			classPath = classPath.plus(jar)	
		}
	}
	File("dependencies_list").writeText(classPath)
	val compileIt = listOf("kotlinc", projectName+".kt", "-include-runtime","-d",projectName+".jar", "-cp",classPath)
	ProcessBuilder(compileIt).redirectError(ProcessBuilder.Redirect.INHERIT).start().waitFor()

	val unzipIt = listOf("unzip", "-qq", currentDirectory+"/"+projectName+".jar", "-d", tempDirectory)
	ProcessBuilder(unzipIt).redirectError(ProcessBuilder.Redirect.INHERIT).start().waitFor()

	var projectMainclass:String? = null
	File(tempDirectory).walk().forEach {
		if ("class" in it.toString()){
			projectMainclass = it.toString().replace(".class","")
		}
	}
	File(tempDirectory).deleteRecursively()
	
	var runIt = listOf("java","-classpath",projectName+".jar:"+classPath, projectMainclass)
	ProcessBuilder(runIt).redirectError(ProcessBuilder.Redirect.INHERIT).start().waitFor()
}
