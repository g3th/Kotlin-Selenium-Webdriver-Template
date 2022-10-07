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

fun main(){
	ProcessBuilder("clear").redirectOutput(ProcessBuilder.Redirect.INHERIT).start().waitFor()

}
