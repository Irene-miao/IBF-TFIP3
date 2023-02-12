package sg.edu.nus.iss.app;

import java.io.File;
import java.io.IOException;

public class FileService {


    // create directory method
    public boolean createDirectory(String directoryName) {
       
        File directory = new File(directoryName);

        Boolean directoryCreated = directory.mkdir();

        return directoryCreated;
    
    }

    // create file method
    public Boolean createFile(String directoryName, String fileName) throws IOException{
        
        // create file
        File newFile = new File(directoryName + File.separator + fileName);
        Boolean FileCreated = newFile.createNewFile();
        return FileCreated;
    }

    //  list files in directory method
    public void listDirectoryFiles(String directoryName) throws IOException {

        // create directory
        File FileDir = new File(directoryName);

        // if directory exists, save files inside to array of files
        if (FileDir.exists()) {
            File FileList[] = FileDir.listFiles();
        
            // iterate through array, get file path, get Canonical file 
            for (File file : FileList) {
                System.out.println(file.getPath() + file.separator + file.getCanonicalFile().toString());
            }
        } else {
            System.out.println("Directory" + directoryName + "does not exist");
        }
       
    }

    
}
