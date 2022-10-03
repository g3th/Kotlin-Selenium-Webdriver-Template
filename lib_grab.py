# place this script in gradle's cache directory,
# where dependencies are stored
# i.e. '.gradle/caches/modules-2/files-2.1'

import os
import shutil
from pathlib import Path

jar_file_paths = []
dir_path = str(Path(__file__).parent)
destination_path = dir_path + "/dependencies/"
present_directories = os.listdir(dir_path)
os.makedirs(destination_path, exist_ok = True)

for root, dirs, files in os.walk(dir_path, topdown=False):
	for name in files:
		if "jar" in str(name):
			jar_file_paths.append(os.path.join(root, name))
		else:
			pass

classpath_list = []
		
for jarfile_path_index in range(len(jar_file_paths)):

	classpath_list.append(jar_file_paths[jarfile_path_index].split("/")[-1])
	
	shutil.copy(jar_file_paths[jarfile_path_index], destination_path + str(jar_file_paths[jarfile_path_index].split("/")[-1]))
	
print("\nThese are your dependencies, paste into 'classpath':\n")
print("-classpath ",end='')
counter = 0 
for jarfile in classpath_list:
	print("{}".format(jarfile),end='')
	counter += 1
	if counter != len(classpath_list):
		print(":",end='')
	
