import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.net.URL
import java.util.*

fun downloadTest(){
	println("\u001b[H\u001b[2J")
	var page = URL("https://images.pexels.com/photos/114820/pexels-photo-114820.jpeg")
	System.setProperty("http.agent","Chrome")
	page.openStream().use{
		Files.copy(it,Paths.get("downloads/image.jpg"))
	}
}

fun removeListElementsTest(){
	val testList:List<String> = listOf("1","2","3","4")
	var newList:List<String> = emptyList()
	println("Keep how many list elements: ")
	var listIndexes = readLine()!!.toInt()
	var counter:Int = 0
	while (counter != listIndexes){
		newList = newList.plus(testList[counter])
		++counter
		}
}

fun getFileNames():List<String>{
	var fileList:List<String> = emptyList()
		var currentDirectory = Paths.get("").toAbsolutePath().toString()
		var imagePath = File(currentDirectory + "/downloads").toPath()
		Files.walk(imagePath).filter {
			Files.isRegularFile(it)
			}.forEach {	
				fileList = fileList.plus(it.toString())
				}
		return fileList
}

fun getTotalFileSize(files:List<String>): Long?{
	var fileSizesInBytes:List<Long> = emptyList()
	for (imageFile in files){
		fileSizesInBytes = fileSizesInBytes.plus(Files.size(File(imageFile).toPath()))
		}
	return fileSizesInBytes.sum()
}

fun main(){
	ProcessBuilder("clear").redirectOutput(ProcessBuilder.Redirect.INHERIT).start().waitFor()
	var longValue:Long = 94737655
	println(String.format("%,d",longValue))
	var currentDirectory = Paths.get("").toAbsolutePath().toString()
	var tempDirectory = currentDirectory + "/temp"
	var fileList:List<String> = emptyList()
	Files.walk(File(tempDirectory).toPath()).filter {
			Files.isRegularFile(it)
			}.forEach {	
				fileList = fileList.plus(it.toString())
				}
	println(fileList)
	
}
