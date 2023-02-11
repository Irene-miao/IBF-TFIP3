package sg.edu.nus.iss;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    
    public static String fileName = "idioms.txt";
    public static String dirName = "day08data";
    public static String dirFileName = dirName + File.separator + fileName;
        
    public static void main(String[] args)  throws IOException{

        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("kill")) {
                System.out.println("Ending program...");
                System.exit(0);
            }
        }

        
        FileService fx = new FileService();
         Boolean directoryCreated = fx.createDirectory(dirName);

         if (directoryCreated) {
            System.out.println("Directory created: "+ dirName);
         } else {
            System.out.println("Directory already exists: " + dirName);
         }

         Boolean fileCreated = fx.createFile(dirName, fileName);

         
            
            if (fileCreated) {
                System.out.println("file created:" + fileName);
            } else {
                System.out.println("file already exist" + fileName);
            }

            Console cons = System.console();
            String conInput = "";

            IdiomService idiomSvc = new IdiomService();
            List<String> idioms = null;


            ProfileService ps = new ProfileService();


            while (!conInput.equalsIgnoreCase("Q")) {
                String randomIdiom = "";

                displayMenu();
                conInput = cons.readLine("Enter your selection");

                switch(conInput) {
                    case "1":
                        CSVExample();
                        break;
                    case "2":
                        idioms = new ArrayList<String>();
                        idiomSvc.readFile(dirFileName);
                        break;
                    case "3":
                        randomIdiom = idiomSvc.randomIdiom(idioms);
                        message(randomIdiom);
                        break;
                    case "4":
                        idiomSvc.showAllIdioms(
                        break;
                        );
                    case "5":
                        ps.readFile();
                        break;   
                    case "Q":
                        message("Bye...");
                        break;
                    default:
                        break;
                }
            }
        

       
        
    }

    public static void CSVExample() throws IOException {
        try {
            /*  FileOutputStream fos = new FileOutputStream(dirFileName);
              
             for (int i = 0; i < 20; i ++) {
                //byte str[] = ByteBuffer.allocate(2).putInt(i).array();
                char str[] = Integer.toString(i).toCharArray();

                // write string in char array
                fos.write(str[0]);
                fos.write('\n');*/



            // write string in byte array
           /* fos.write(str);
            fos.write('\n');*/
             


             EmployeeService es = new EmployeeService();
             List<Employee> empList = es.generateEmployees();

             CSVService cvSvc = new CSVService();
             cvSvc.writeToCSV(empList, dirFileName);

             List<Employee> csvEmpList = cvSvc.readFromCSV(dirFileName);
             csvEmpList.forEach(emp -> System.out.println(emp));

         } catch (FileNotFoundException e) {
            e.printStackTrace();
         }
    }

    public static void displayMenu() throws IOException {
        message("Welcome to my App");
        message("===========================");
        message("1: CSV Read and write Text");
        message("2: Read from file");
        message("3: Pick up idioms");
        message("1: CSV Read and write Text");
    }

    public static void message(String line) {
System.out.println(line);
    }
}
