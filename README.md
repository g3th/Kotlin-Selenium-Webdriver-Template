# Kotlin Selenium Webdriver Template
### Manual template for beginner selenium-webdriver project in Kotlin

Add all dependencies manually and compile .kt script to start selenium webdriver. This avoids using bloated IDEs (IntelliJ, Android Studio etc...) for speed. Compile time is much faster than using these terrible tools, but efficiency might suffer.

Add all the required libraries in the project (search Maven or clone this repo) and compile the project with:

```kotlinc package_scraper.kt -include-runtime -d package_scraper.jar -classpath guava.jar:selenium.chromium.driver.jar:selenium.chrome.driver.jar:selenium.jar:selenium.remote.driver.jar:selenium.devtools.jar:selenium.http.jar:google.collections.jar:failsafe.jar:netty.jar:async.http.client.jar:slf4j.jar:netty.jar:reactive.streams.jar:commons.executor.jar:selenium.json.jar```

Then:

```java -cp package_scraper.jar:guava.jar:selenium.chromium.driver.jar:selenium.chrome.driver.jar:selenium.jar:selenium.remote.driver.jar:selenium.devtools.jar:selenium.http.jar:google.collections.jar:failsafe.jar:netty.jar:async.http.client.jar:slf4j.jar:netty.jar:reactive.streams.jar:commons.executor.jar:selenium.json.jar Package_scraperKt```

This project required Kotlin native compiler, chromium-driver and all libraries included here.

Note: The browser launches fine, but no page loads, for now.
