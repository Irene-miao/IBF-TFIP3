package myapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ToMain {
    
    // entrypoint

    public static void main(String[] args) throws IOException {
        
        System.out.printf("args length: %d\n", args.length);
        for (String a : args) {
            System.out.printf("%s\n", a);
        }

        // Get a reference to the file
        Path p = Paths.get(args[0]);


        // Get actual file object
        File f = p.toFile();


        // Info from file object
        System.out.printf("Exists %b\n", f.exists());
        System.out.printf("is file %b\n", f.isFile() );
        System.out.printf("is directory? %b\n", f.isDirectory());
        System.out.printf("size of file : %d\n", f.length());
        System.out.printf("Can read? %b\n", f.canRead());
        System.out.printf("Full path %s\n", f.getAbsolutePath());


        // Open file for reading:
        InputStream is = new FileInputStream(f);

        OutputStream os = new FileOutputStream("Copy of: %s".formatted(args[0]));
        
        byte[] buffer = new byte[1024]; // 1k buffer
        int size = 0;

        while ((size = is.read(buffer)) > 0) {
            os.write(buffer, 0, size);

        }

       /*  while (size >= 0){
            size = is.read(buffer);
            if (size > 0) {
                os.write(buffer,  0, size);
            }*/

            os.flush();
            os.close();

            is.close();
        }


    }

