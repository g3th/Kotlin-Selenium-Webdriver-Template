# Kotlin Selenium Webdriver Template
### Manual template for beginner selenium-webdriver project in Kotlin

Add all dependencies manually and compile .kt script to start selenium webdriver. This avoids using bloated IDEs (IntelliJ, Android Studio etc...) for speed. Compile time is much faster than using these terribly slow, cancerous tools, and it does not cause performance issues like when launching the tools indicated. However, efficiency might suffer.

To add all required libraries launch 'lib_grab.py' into the directory where your '.gradle/caches/' is located (i.e. '.gradle/caches/modules-2/files-2.1'). This is where gradle stores all the project dependecies when launching a project with ``gradle run```.

Since selenium had very specific jar dependencies when run from Kali Linux, it was easier to build the project with gradle (as mentioned above), and grabbing all needed jars with the python script. However, you can still use the script to copy any project dependencies so that your project can be compiled solely with the kotlin-native compiler.

To get needed dependencies:

- place ```lib_grab.py``` into the directory mentioned above
- launch the script
- the script will create a 'dependencies' directory where all needed jars are stored
- copy the jars into your .kt project folder
- copy the 'classpath' output from the script. (i.e. -classpath jar1:jar2 etc...)
~~compile your project with ```kotlinc project.kt -include-runtime -d project.jar -classpath``` and pasted dependencies output from the script~~
~~launch with ``` java -classpath ``` pasted output and your main class ```projectKt```~~

Compile the project with ```compile.py```. After launch, cleanup files with ```cleanup.py```.


Warning: Some projects, like this automation template, have lots of dependencies and will be quite bloated.

~~Note: The browser launches fine, but no page loads, for now. Tested on Debian/Kali linux only.~~

Update: Browser launches, and fetches the web page in the script.
