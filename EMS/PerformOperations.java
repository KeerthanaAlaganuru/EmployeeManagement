package EMS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PerformOperations implements CRUDOperations {
    Connection con;

    @Override
    public void createEmployee(Employee emp) {
        con = DBConnection.createDBConnection();
        String query = "INSERT INTO DetailsOfEmployee (id, name, age, salary, phno, email, role) VALUES (" +
                emp.getId() + ", '" + emp.getName() + "', " + emp.getAge() + ", " + emp.getSalary() + ", '" +
                emp.getPhno() + "', '" + emp.getEmail() + "', '" + emp.getRole() + "')";
        try {
            Statement stmt = con.createStatement();
            int cnt = stmt.executeUpdate(query);
            if (cnt != 0)
                System.out.println("Details Inserted Successfully !!!");

        } catch (Exception ex) {
            ex.printStackTrace(); //need to throw exception for proper handling
        }
    }

    @Override
    public void showAllEmployee(String role, int loggedInId) {
        if (!role.equalsIgnoreCase("Admin")) {
            System.out.println("Access denied! Only Admin can view all employees.");
            return;
        }

        con = DBConnection.createDBConnection();
        String query = "SELECT * FROM DetailsOfEmployee";
        System.out.println("Employee Details :");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-10s %-10s %-15s %-20s %-5s\n", "ID", "Name", "Age", "Salary", "Phone", "Email", "Role");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------------------------");
        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                System.out.printf("%-10d %-15s %-10d %-10.2f %-15s %-20s %-5s\n",
                        result.getInt("id"),
                        result.getString("name"),
                        result.getInt("age"),
                        result.getDouble("salary"),
                        result.getString("phno"),
                        result.getString("email"),
                        result.getString("role"));
                System.out.println("----------------------------------------------------------------------------------------------------");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void showEmployeeBasedOnID(int id) {
        con = DBConnection.createDBConnection();
        String query = "SELECT * FROM DetailsOfEmployee WHERE id = " + id;
        System.out.println("Getting Employee Details based on the ID:");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-10s %-10s %-15s %-20s %-5s\n", "ID", "Name", "Age", "Salary", "Phone", "Email", "Role");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------");
        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            if (result.next()) {
                System.out.printf("%-10d %-15s %-10d %-10.2f %-15s %-20s %-5s\n",
                        result.getInt("id"),
                        result.getString("name"),
                        result.getInt("age"),
                        result.getDouble("salary"),
                        result.getString("phno"),
                        result.getString("email"),
                        result.getString("role"));
                        System.out.println("----------------------------------------------------------------------------------------------------");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int id, String name, int age, double salary, String phno, String email) {
        con = DBConnection.createDBConnection();
        String query = "UPDATE DetailsOfEmployee SET name='" + name + "', age=" + age + ", salary=" + salary +
                ", phno='" + phno + "', email='" + email + "' WHERE id=" + id;
        try {
            Statement stmt = con.createStatement();
            int cnt = stmt.executeUpdate(query);
            if (cnt != 0)
                System.out.println("Employee Details updated successfully !!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteEmployee(int id, int loggedInAdminId) {
        if (id == loggedInAdminId) {
            System.out.println("Access denied! Admin cannot delete their own details.");
            return;
        }
        
        con = DBConnection.createDBConnection();
        String query = "DELETE FROM DetailsOfEmployee WHERE id=" + id;
        try {
            Statement stmt = con.createStatement();
            int cnt = stmt.executeUpdate(query);
            if (cnt != 0)
                System.out.println("Details with ID " + id + " deleted Successfully!!!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public String verifyRole(int id) {
        con = DBConnection.createDBConnection();
        String query = "SELECT role FROM DetailsOfEmployee WHERE id=" + id;
        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            if (result.next()) {
                return result.getString("role");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
