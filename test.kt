import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.net.URL


fun main(){
	println("\u001b[H\u001b[2J")
	var page = URL("https://images.pexels.com/photos/114820/pexels-photo-114820.jpeg")
	System.setProperty("http.agent","Chrome")
	page.openStream().use{
		Files.copy(it,Paths.get("downloads/image.jpg"))	
	}
}
