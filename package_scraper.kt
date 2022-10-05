import org.jsoup.*
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.devtools.HasDevTools
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.chromium.ChromiumDriver

fun main(){

	System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver")
	print("\nEnter Query: ")
	
	var userQuery = readLine()	
	var scrollIncrement:Int = 2000
	var counter:Int = 0
	var linksList:List<WebElement> = emptyList()
	val browserOptions = ChromeOptions()
	browserOptions.addArguments("user-agent=Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.101 Safari/537.36")
	val browser: WebDriver = ChromeDriver(browserOptions)	
	browser.get("https://www.pexels.com/search/${userQuery}")
	
	while (counter !=2){
			Thread.sleep(2000)			
			scrollIncrement + 2000
			++counter
		}
		
	var findTags: List<WebElement> = browser.findElements(By.tagName("img")
	for (tag in findTags){		
		linksList = linksList.plus(findTags))
		}
		
	println(linksList)
}
