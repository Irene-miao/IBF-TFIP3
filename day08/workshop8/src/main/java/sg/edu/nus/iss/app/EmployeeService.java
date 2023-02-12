package sg.edu.nus.iss.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeService {
    
    // Variable
    public List<Employee> employees;

    // Get employees method
    public List<Employee> generateEmployees() {

        // Instantiate employees variable
        employees = new ArrayList<Employee>();

        // Create an instance of Employee
        Employee emp = new Employee("1111", "Bob Tan", "ISS", "bob@mail.com", "lect", 8000);
       // add created instance to list
        employees.add(emp);
        Employee emp2 = new Employee("2222", "Jo Lee", "ISS", "jo@mail.com", "admin", 3000);
        employees.add(emp2);
        Employee emp3 = new Employee("3333", "Pop Mei", "ISS", "pop@mail.com", "cleaner", 2000);
        employees.add(emp3);
        Employee emp4 = new Employee("1234", "John Day", "ISS", "john@mail.com", "technician", 4000);
        employees.add(emp4);
    
        
    
        // return value of list
        return employees;
    
    }
    
}
