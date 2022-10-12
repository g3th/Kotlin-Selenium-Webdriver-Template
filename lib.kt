import java.nio.file.Paths
import java.io.File

fun main(){
	val directoryAsString = Paths.get("").toAbsolutePath().toString()
	var jarFiles:List<File> = emptyList()
	
	File(directoryAsString).walk().forEach{
		if (".jar" in it.toString() && it.toString() != (directoryAsString + "/" + "lib.jar") ){
			jarFiles = jarFiles.plus(it)		
		}	
	}
	File(directoryAsString+"/dependencies/").mkdir()
	for (jar in jarFiles){
		jar.copyTo(File(directoryAsString + "/dependencies/${jar.toString().substringAfterLast("/")}") )
	}
}
