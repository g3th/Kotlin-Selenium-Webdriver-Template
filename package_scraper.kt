import org.jsoup.*
import java.io.File
import java.nio.file.Paths
import java.nio.file.Files
import java.net.URL
import kotlin.system.exitProcess
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

fun clearScreen(){
	ProcessBuilder("clear").redirectOutput(ProcessBuilder.Redirect.INHERIT).start().waitFor()
	}

fun main(){
	clearScreen(
	val directory = Paths.get("").toAbsolutePath().toString()
	File(directory + "/downloads/").mkdir()
	print("\nEnter Query: ")
	var findTags: List<WebElement> = emptyList()
	var imageQuery = readLine()
	print("\nEnter number of Pages to scrape: ")
	var numberOfPages = readLine() 
	var scrollIncrement:Int = 2000
	var counter:Int = 0
	var linksList:List<String> = emptyList()
	val browserOptions = ChromeOptions()
	browserOptions.addArguments("--headless")
	System.setProperty("http.agent","Chrome")
	browserOptions.addArguments("user-agent=Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.101 Safari/537.36")

	var browser: WebDriver = ChromeDriver(browserOptions)	
	browser.get("https://www.pexels.com/search/${imageQuery}")
	while (counter != numberOfPages!!.toIntOrNull()){
			(browser as JavascriptExecutor).executeScript("window.scrollBy(0,${scrollIncrement.toString()})") 
			clearScreen()
			println("Fetching Page ${counter}")	
			Thread.sleep(2000)			
			scrollIncrement + 2000
			++counter
		}
	findTags = browser.findElements(By.xpath("//*[@href]"))
	for (tag in findTags){
		clearScreen()
		var foundImageNumber = linksList.size + 1
		var printTags:Int = findTags.size + 1
		println("Scraper returned ${printTags} links \nsorting into images (Found ${foundImageNumber}} images)")
		if ("&fm=jpg" in tag.getAttribute("href")){
			linksList = linksList.plus(tag.getAttribute("href"))
			}
		}
	browser.close()
	var imageCounter = 1
	var imageLinks:List<String> = emptyList()
	var splitImageLink:List<String> = emptyList()
	for (link in linksList){
		splitImageLink = link.split("?cs=")
		imageLinks = imageLinks.plus(splitImageLink[0])
		}
	var printImageLinks:Int = imageLinks.size + 1
	println("There are a total of ${printImageLinks} Images")
	println("How many would you like to download?")		
	var listIndexes = readLine()!!.toInt()
	var newImageLinkList:List<String> = emptyList()
	counter = 0
	while (counter != listIndexes){
		newImageLinkList = newImageLinkList.plus(imageLinks[counter])
		++counter
		}
	for (image in newImageLinkList){
		clearScreen()
		println("Downloading Image ${imageCounter} out of ${printImageLinks} Images")
		var imageURL = URL(image)
		imageURL.openStream().use{
			Files.copy(it, Paths.get("downloads/${imageQuery}_image_${imageCounter.toString()}.jpg"))
			}
		++ imageCounter
		}
}
