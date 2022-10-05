import org.jsoup.*
import java.io.File
import java.nio.file.Paths
import kotlin.system.exitProcess
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions


fun main(){
	val directory = Paths.get("").toAbsolutePath().toString()
	File(directory + "/downloads/").mkdir()
	System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver")
	print("\nEnter Query: ")
	var findTags: List<WebElement> = emptyList()
	var userQuery = readLine()	
	var scrollIncrement:Int = 2000
	var counter:Int = 0
	var linksList:List<String> = emptyList()
	val browserOptions = ChromeOptions()
	browserOptions.addArguments("user-agent=Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.101 Safari/537.36")
	val browser: WebDriver = ChromeDriver(browserOptions)	
	browser.get("https://www.pexels.com/search/${userQuery}")
	
	while (counter !=2){
			findTags = findTags.plus(browser.findElements(By.xpath("//*[@href]")))
			Thread.sleep(2000)			
			scrollIncrement + 2000
			++counter
		}
	for (tag in findTags){
		if ("&fm=jpg" in tag.getAttribute("href")){
			linksList = linksList.plus(tag.getAttribute("href"))
			}
		}
	
	println(linksList)
}
