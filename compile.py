import subprocess
import os
import shutil
from pathlib import Path

mainclass = input("Enter project name (no extension, i.e. 'project' not 'project.kt'): ")
directory = str(Path(__file__).parent)
temp_directory = directory + "/temp/"
dependencies_directory = directory + "/libs/"
jarlist = []
os.makedirs(temp_directory, exist_ok = True)

for jarfile in os.listdir(dependencies_directory):
	if "jar" in str(jarfile):
		jarlist.append(jarfile)

counter = 0
classpath_string = ""

for jar in jarlist:
	classpath_string += dependencies_directory + jar+":"
	counter += 1
	if counter == len(jarlist):
		classpath_string += jar

with open("dependencies_list",'w') as cp:
	cp.write(classpath_string)
cp.close()

compile_it = ["kotlinc", mainclass+".kt", "-include-runtime","-d",mainclass+".jar", "-cp",classpath_string]
subprocess.run(compile_it, shell=False, capture_output = True)
unzip_it = ["unzip", "-qq", directory+"/"+mainclass+".jar", "-d", temp_directory]
subprocess.run(unzip_it, shell=False)
project_mainclass = ""

for filelist in os.listdir(temp_directory):
	if "class" in str(filelist):
		project_mainclass = filelist.replace(".class","")

shutil.rmtree(temp_directory)
classpath_string = mainclass+".jar:"+classpath_string

run_it = ["java","-classpath",mainclass+".jar:"+classpath_string, project_mainclass]
subprocess.run(run_it,shell=False)

print("\nRun 'cleanup.py' to delete files and re-compile")

