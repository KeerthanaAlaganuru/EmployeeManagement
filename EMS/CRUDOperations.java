package EMS;

public interface CRUDOperations {

    // Create employee
    void createEmployee(Employee emp);

    // Show all employees
    void showAllEmployee(String loggedInUserRole, int id);

    // Show employee based on id
    void showEmployeeBasedOnID(int id);

    // Update employee
    void updateEmployee(int id, String name, int age, double salary, String phno, String email);

    // Delete employee
    void deleteEmployee(int id, int loggedInAdminId);

    // Verify role and ID
    String verifyRole(int id);
}
