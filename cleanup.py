import os
from pathlib import Path

directory = str(Path(__file__).parent)+"/"
os.remove(directory + "dependencies_list")

for jars in os.listdir(directory):
	if "jar" in str(jars):
		os.remove(directory + jars)				
