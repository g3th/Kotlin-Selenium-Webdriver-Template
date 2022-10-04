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
	var linksList:List<String> = emptyList()
	val browserOptions = ChromeOptions()
	val browser: WebDriver = ChromeDriver(browserOptions)
	
	browserOptions.addArguments("""general.useragent.override","Mozilla/5.0 (iPhone; CPU iPhone OS 12_1 like Mac OS X) AppleWebKit/605.1.15 ","(KHTML, like Gecko) FxiOS/18.1 Mobile/16B92 Safari/605.1.15""")
	
	browser.get("https://www.pexels.com/search/${userQuery}")
	while (counter !=5){	
			(browser as JavascriptExecutor).executeScript("window.scrollBy(0,${scrollIncrement})")
			var rawPage = browser.findElement(By.xpath("//*[@href]"))
			print(rawPage)
			linksList.plus(rawPage.toString())
			scrollIncrement + 2000
			++counter
		}
	println(linksList)
}
