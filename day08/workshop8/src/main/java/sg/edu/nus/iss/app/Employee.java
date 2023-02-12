package sg.edu.nus.iss.app;

public class Employee {
    
    // members
    private String staffNo;
    private String fullName;
    private String department;
    private String email;
    private String role;
    private Integer salary;
    
    
    //constructor
    public Employee() {
    }


    public Employee(String staffNo, String fullName, String department, String email, String role, Integer salary) {
        this.staffNo = staffNo;
        this.fullName = fullName;
        this.department = department;
        this.email = email;
        this.role = role;
        this.salary = salary;
    }


    // Getter and setter
    public String getStaffNo() {
        return this.staffNo;
    }


    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }


    public String getFullName() {
        return this.fullName;
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getDepartment() {
        return this.department;
    }


    public void setDepartment(String department) {
        this.department = department;
    }


    public String getEmail() {
        return this.email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getRole() {
        return this.role;
    }


    public void setRole(String role) {
        this.role = role;
    }


    public Integer getSalary() {
        return this.salary;
    }


    public void setSalary(Integer salary) {
        this.salary = salary;
    }


    // methods
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((staffNo == null) ? 0 : staffNo.hashCode());
        result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
        result = prime * result + ((department == null) ? 0 : department.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        result = prime * result + ((salary == null) ? 0 : salary.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (staffNo == null) {
            if (other.staffNo != null)
                return false;
        } else if (!staffNo.equals(other.staffNo))
            return false;
        if (fullName == null) {
            if (other.fullName != null)
                return false;
        } else if (!fullName.equals(other.fullName))
            return false;
        if (department == null) {
            if (other.department != null)
                return false;
        } else if (!department.equals(other.department))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        if (salary == null) {
            if (other.salary != null)
                return false;
        } else if (!salary.equals(other.salary))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Employee [staffNo=" + staffNo + ", fullName=" + fullName + ", department=" + department + ", email="
                + email + ", role=" + role + ", salary=" + salary + "]";
    }


    
}
