package sg.edu.nus.iss.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVService {
    
    public static final String FILE_HEADER = "staffNo, fullName, department, role email, salary";
    public static final String COMMA_DELIMITER = ",";
    public static final String NEW_LINE = "\n";


    // write to file method
    public void writeToCSV(List<Employee> employees, String fullPathFileName) throws IOException {
        
        // Write to a file
        FileWriter fw = new FileWriter(fullPathFileName);

        // add header and break new line
        fw.append(FILE_HEADER);
        fw.append(NEW_LINE);

        // processing to write record by record in this sequence
        // staffNo, fullName, department, role, email, salary

        // iterate through list
        for (Employee emp : employees) {
            fw.append(emp.getStaffNo());
            fw.append(COMMA_DELIMITER);
            fw.append(emp.getFullName());
            fw.append(COMMA_DELIMITER);
            fw.append(emp.getDepartment());
            fw.append(COMMA_DELIMITER);
            fw.append(emp.getRole());
            fw.append(COMMA_DELIMITER);
            fw.append(emp.getEmail());
            fw.append(COMMA_DELIMITER);
            fw.append(String.valueOf(emp.getSalary()));
            fw.append(COMMA_DELIMITER);
            fw.append(NEW_LINE);
        }

        fw.flush(); // clear
        fw.close(); // close
    }

    // read file method
    public List<Employee> readFromCSV(String fullPathFileName) throws IOException {

        FileReader fr = new FileReader(fullPathFileName);

        BufferedReader br = new BufferedReader(fr);

        String line;

        // Create ArrayList
        List<Employee> employees = new ArrayList<Employee>();

        // skip header
        line = br.readLine();

        while ((line = br.readLine()) != null) {
            // extract data separated by comma
            String [] strEmployee = line.split(COMMA_DELIMITER);

            // put it into an employee object
            // add to employees list object
            if (strEmployee.length > 0){
                
                Employee emp = new Employee(strEmployee[0], strEmployee[1], strEmployee[2], strEmployee[3], strEmployee[4], Integer.parseInt(strEmployee[5]));
                employees.add(emp);
            }
        }

        br.close();
        fr.close();

        return employees; // return employees list






















    }
}
