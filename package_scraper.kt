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
	browser.get("https://www.google.co.uk/search?q=bananas&tbm=isch&source=hp&biw=1380&bih=702&ei=AG87Y7-2D8mGhbIPtLSWgAQ&iflsig=AJiK0e8AAAAAYzt9EFdV6J06nCQ1wxANNR_CsaAQmE5J&ved=0ahUKEwi_tvaTmsX6AhVJQ0EAHTSaBUAQ4dUDCAc&uact=5&oq=bananas&gs_lcp=CgNpbWcQAzIICAAQgAQQsQMyCAgAEIAEELEDMggIABCABBCxAzIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgAQyBQgAEIAEMgUIABCABDIFCAAQgARQgQZY-BBg5xFoAXAAeACAAWeIAd0EkgEDNi4xmAEAoAEBqgELZ3dzLXdpei1pbWewAQA&sclient=img")
}
