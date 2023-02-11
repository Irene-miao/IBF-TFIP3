package sg.edu.nus.iss;

import java.io.File;
import java.io.IOException;

public class FileService {
    public Boolean createDirectory(String directoryName) {
        File directory = new File(directoryName);

        Boolean directoryCreated = directory.mkdir();
        
        return directoryCreated;
        
    
    }

    public Boolean createFile(String directoryName, String fileName) throws IOException {
        File newFile = new File(directoryName + File.separator + fileName);
       Boolean FileCreated = newFile.createNewFile();
       return FileCreated;
    }

    public void listDirectoryFiles(String directoryName) throws IOException {
File FileDir = new File( directoryName);

if (FileDir.exists()) {
    File FileList[] = FileDir.listFiles();

    for (File file : FileList) {
        System.out.println(file.getPath() + file.separator + file.getCanonicalFile().toString());
    }
} else {
    System.out.println("Directory "  + directoryName + " does not exists");
}
    }


}
