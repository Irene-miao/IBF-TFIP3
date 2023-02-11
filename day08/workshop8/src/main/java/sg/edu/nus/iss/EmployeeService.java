package sg.edu.nus.iss;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    

    public List<Employee> employees;

    

    public List<Employee> generateEmployees() {
        employees = new ArrayList<Employee>();

        Employee emp = new Employee("1234", "Daniel", "SS", "Lect", "daniel@gmail.com", 8000);
        employees.add(emp);
        Employee emp1 = new Employee("4444", "Tom", "SS", "Admin", "tom@gmail.com", 2000);
        employees.add(emp1);
        Employee emp2 = new Employee("3333", "Jane", "SS", "Cleaner", "jane@gmail.com", 1000);
        employees.add(emp2);
        
        return employees;
    }
}
