package sg.edu.nus.iss.app;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;




/**
 * Hello world!
 *
 */
public class App 
{
    private App() {

    }

    public static String fileName = "employees.txt";
    public static String dirName = "day08data";
    public static String dirFileName = dirName + File.separator + fileName;
    

    public static void main( String[] args ) throws IOException
    {
        
        // if input contains "kill" word, the app will exit
        /*if (args.length > 0) {
            if (args[0].equalsIgnoreCase("kill")) {
                System.out.println("Ending program.. ");
                System.exit(0);
            }
        }

        // Create instance of FileService
        FileService fs = new FileService();

        // Create directory
        Boolean directoryCreated = fs.createDirectory(dirName);

        // Check if directory exists
        if (directoryCreated) {
            System.out.println("Directory created: " + dirName);
        } else {
            System.out.println("Directory already existed:" + dirName);
        }


        // Create file
        Boolean fileCreated = fs.createFile(dirName, fileName);

        // Check if file exist
        if (fileCreated) {
            System.out.println("file created: " + fileName);
        } else {
            System.out.println("file already exists:" + fileName);
        }


        // Read input from console
        Console cons = System.console();

        String input = "";

        // IdiomService instance
        IdiomService iSvc = new IdiomService();
        List<String> idioms = null;

        // ProfileService instance
        ProfileService ps = new ProfileService();

        while (!input.equalsIgnoreCase("Q")) {
            String randomIdiom = "";

            displayMenu();
            input = cons.readLine("Enter your selection");

            switch (input) {
                case "1":
                    CSVExample();
                    break;
                case "2":
                    idioms = new ArrayList<String>();    
                    idioms = iSvc.readFile(dirName + File.separator + "idioms.txt");
                    //idioms.forEach(System.out::println);
                    break;
                case "3":
                    randomIdiom = iSvc.randomIdiom(idioms);
                    message(randomIdiom);
                    break;
                case "4":
                    iSvc.showAllIdioms(idioms);
                    break; 
                case "5":
                    ps.readFile();
                    break;
                case "Q":
                case "q":
                    message("Bye.....");
                    break;
                default:
                    break;       
            }
        }*/

        ServerSocket server = new ServerSocket(12345);
        Socket sock = server.accept();
        System.out.printf("Server listen at socket port: %s", sock.getPort());
        System.out.println("Server started at..." + sock.getLocalSocketAddress().toString());
        
        Thread idiomThread = new Thread(new IdiomService(sock, dirFileName));
        idiomThread.start();

        
    }

    
    
    
    // CSV method
    public static void CSVExample() throws IOException {

        try {
        EmployeeService es = new EmployeeService();
        List<Employee> empList = es.generateEmployees();
        
            // stream and filter
            List<Employee> filterEmployees = empList.stream().filter(e -> e.getFullName().equalsIgnoreCase("Pop Mei"))
            .collect(Collectors.toList());
            System.out.println(filterEmployees); 

            // sort salary in ascending order
           empList.sort(Comparator.comparing(e -> e.getSalary()));
            System.out.println(empList);

            // sort salary in descending order
            Comparator<Employee> comparator = Comparator.comparing(e -> e.getSalary());
            empList.sort(comparator.reversed());
            System.out.println(empList);

        System.out.println(empList);

        CSVService csvSvc = new CSVService();

        // write to file
        csvSvc.writeToCSV(empList, dirFileName);

        // read to file
        List<Employee> csvEmpList = csvSvc.readFromCSV(dirFileName);
        csvEmpList.forEach(emp -> System.out.println(emp));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}

// App menu method
public static void displayMenu() {

    message("Welcome to App");
    message("===============================");
    message("1: CSV Read and Write Text");
    message("2: Read Idioms File");
    message("3: Pick an idiom randomly");
    message("4: List all idioms");
    message("5: Read text file and check for word");
    message("Q: quit program");
    
    
}

// print message line method
public static void message(String line) {
    System.out.println(line);
}
}

