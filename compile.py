import subprocess
import os
import shutil
from pathlib import Path

mainclass = input("Enter project name (no extension, i.e. 'project' not 'project.kt'): ")

directory = str(Path(__file__).parent)
temp_directory = directory + "/temp/"
jarlist = []
os.makedirs(temp_directory, exist_ok=True)

for jarfile in os.listdir(directory):
	if "jar" in str(jarfile):
		jarlist.append(jarfile)

counter = 0
classpath_string = ""

for jar in jarlist:
	classpath_string += jar+":"
	counter += 1
	if counter == len(jarlist):
		classpath_string += jar

with open("classpath",'w') as cp:
	cp.write(classpath_string)
cp.close()

compile_it = ["kotlinc", mainclass+".kt", "-include-runtime","-d",mainclass+".jar ", "-cp",classpath_string]
subprocess.run(compile_it, shell=False)

unzip_it = ["unzip","-qq",mainclass+".jar","-d "+temp_directory]
subprocess.run(unzip_it, shell=False)
exit()
project_mainclass = ""

for mainclass in os.listdir(temp_directory):
	if "class" in str(mainclass):
		project_mainclass = mainclass.replace(".class","")

shutil.rmtree(temp_directory)

run_it = ["java","-classpath",mainclass+".jar:",classpath_string, project_mainclass]
subprocess.run(run_it,shell=False)


