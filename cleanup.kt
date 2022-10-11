import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.Files
import java.io.File

fun main (){
	val directory = Paths.get("").toAbsolutePath().toString()
	val projectDirectory = File(directory)
	val files = projectDirectory.list()
	var fileList:List<String> = emptyList()
	for (file in files){
		if ("jar" in file.toString() && file != "cleanup.jar"){
			fileList = fileList.plus(file)
		}
	}
	for (file in fileList){
		File(directory + "/" + file).delete()
	}
	if (fileList.size == 0){
		println("No files deleted.")
	}
	else{
		println("The following files were deleted: ${fileList}")
	}
}
