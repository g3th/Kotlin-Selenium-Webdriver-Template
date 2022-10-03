import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.devtools.HasDevTools
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.chromium.ChromiumDriver

fun main(){
	val browserOptions = ChromeOptions()
	browserOptions.addArguments("""general.useragent.override","Mozilla/5.0 (iPhone; CPU iPhone OS 12_1 like Mac OS X) AppleWebKit/605.1.15 ","(KHTML, like Gecko) FxiOS/18.1 Mobile/16B92 Safari/605.1.15""")
	System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver")
	val browser: WebDriver = ChromeDriver(browserOptions)
	browser.get("https://www.google.com")
}
