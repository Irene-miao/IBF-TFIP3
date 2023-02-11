package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class ProfileService {
    
    public  String fileName = "profile.txt";
    public  String dirName = "day08data";
    public  String dirFileName = dirName + File.separator + fileName;
        
    
    public void readFile()  throws FileNotFoundException, IOException{
        
        File file = new File(dirFileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        Console conInput = System.console();

        String line = "";
        String[] buffer;
        int occurence = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter word to search: ");
        String scannerInput = scanner.nextLine();

        while ((line = br.readLine()) != null) {
line.replaceAll(",", " ");
line.replaceAll(",", " ");

            buffer = line.split(" ");

            for (String s : buffer) {
                System.out.printf("word:"+ s);
                if (s.equalsIgnoreCase(scannerInput) ) {
                    occurence++;    
                }
            }
        }

        if (occurence == 0) {
            System.out.printf("word %s is not found", scannerInput);
        } else {
            System.out.printf("word %s occurs %d number of times", scannerInput, occurence);
        }


        br.close();
        fr.close();
        
     }
}
