package sg.edu.nus.iss.app;

public class Employee {

    // members
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;



    // constructor
    public Employee() {
    }

    public Employee(Integer id, String firstName, String lastName, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Getter and setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age; 
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // methods
    @Override
    public String toString() {
        
        return "Employee: " + this.firstName + " " + this.lastName + " "
        + age;
        
    }


    
    
}
