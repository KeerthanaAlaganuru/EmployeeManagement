package EMS;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private int age;
    private String phno;
    private String email;
    private String role; // Add role attribute

    public Employee() {
    }

    public Employee(int id, String name, double salary, int age, String phno, String email, String role) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.phno = phno;
        this.email = email;
        this.role = role;
    }

    // Getters and setters including role
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", phno='" + phno + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
