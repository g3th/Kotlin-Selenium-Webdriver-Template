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
	println("\u001b[H\u001b[2J")
	}

fun main(){

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
			println("Fetching Images on Page ${counter.toString()}")	
			Thread.sleep(2000)			
			scrollIncrement + 2000
			++counter
		}
	findTags = browser.findElements(By.xpath("//*[@href]"))
	for (tag in findTags){
		clearScreen()
		println("Scraper returned ${findTags.size} links \nsorting into images (Found ${linksList.size.toString()}")
		if ("&fm=jpg" in tag.getAttribute("href")){
			linksList = linksList.plus(tag.getAttribute("href"))
			}
		}
	browser.close()
	print(linksList)
	var imageCounter = 0
	var imageLinks:List<String> = emptyList()
	var splitImageLink:List<String> = emptyList()
	for (link in linksList){
		splitImageLink = link.split("?cs=")
		imageLinks = imageLinks.plus(splitImageLink[0])
		}
	for (image in imageLinks){
		clearScreen()
		println("Downloading Image ${imageCounter.toString()} out of ${imageLinks.size.toString()} Images")
		var imageURL = URL(image)
		imageURL.openStream().use{
			Files.copy(it, Paths.get("downloads/${imageQuery}_image${imageCounter.toString()}.jpg"))
			}
		++ imageCounter
		}
}
