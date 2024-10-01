package EMS;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String name, phno, email, role;
        int id;
        CRUDOperations employeeOperations = new PerformOperations();

        String boldStart = "\033[1m"; // ANSI escape code for bold start
        String boldEnd = "\033[0m"; // ANSI escape code for bold end

        System.out.println();
        System.out.println("==============================================================================");
        System.out.println(boldStart + "            WELCOME TO EMPLOYEE MANAGEMENT APPLICATION          " + boldEnd);
        System.out.println("==============================================================================");

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("Enter your ID: ");
                id = sc.nextInt();
                role = employeeOperations.verifyRole(id);

                if (role == null) {
                    System.out.println("Invalid ID! Please try again.");
                    continue;
                }

                String loggedInUserRole = role;
                int loggedInAdminId = id;

                while (true) {
                    System.out.println();
                    System.out.println(boldStart + "Operations you can perform in this system." + boldEnd);
                    System.out.println();
                    System.out.println("1. Add Employee (Admin only)\n" +
                            "2. Show All Employees\n" +
                            "3. Show Employee based on ID\n" +
                            "4. Update Employee\n" +
                            "5. Delete Employee (Admin only)\n" +
                            "6. Exit");
                    System.out.println();
                    System.out.println("Enter your choice: ");
                    int ch = sc.nextInt();
                    switch (ch) {
                        case 1:
                            if (loggedInUserRole.equalsIgnoreCase("Admin")) {
                                Employee emp = new Employee();
                                System.out.println("Enter employee ID: ");
                                int newId = sc.nextInt();
                                System.out.println("Enter employee Name: ");
                                name = sc.next();
                                System.out.println("Enter employee Age: ");
                                int age = sc.nextInt();
                                System.out.println("Enter employee Salary: ");
                                double salary = sc.nextDouble();
                                System.out.println("Enter employee Phone Number: ");
                                phno = sc.next();
                                System.out.println("Enter employee Email: ");
                                email = sc.next();
                                System.out.println("Enter employee Role (Admin/Employee): ");
                                role = sc.next();
                                emp.setId(newId);
                                emp.setName(name);
                                emp.setAge(age);
                                emp.setSalary(salary);
                                emp.setPhno(phno);
                                emp.setEmail(email);
                                emp.setRole(role);
                                employeeOperations.createEmployee(emp);
                            } else {
                                System.out.println("Access denied! Only Admin can add employees.");
                            }
                            break;
                        case 2:
                            employeeOperations.showAllEmployee(loggedInUserRole, id);
                            break;
                        case 3:
                            System.out.println("Enter ID to show the details: ");
                            int empId = sc.nextInt();
                            if (loggedInUserRole.equalsIgnoreCase("Admin") || (loggedInUserRole.equalsIgnoreCase("Employee") && empId == id)) {
                                employeeOperations.showEmployeeBasedOnID(empId);
                            } else {
                                System.out.println("Access denied! Employees can only view their own details.");
                            }
                            break;
                        case 4:
                        
                            System.out.println("Enter the ID of the employee to update: ");
                            int updateId = sc.nextInt();
                            if (loggedInUserRole.equalsIgnoreCase("Admin") || (loggedInUserRole.equalsIgnoreCase("Employee") && updateId == id)) {
                                System.out.println("Enter new name: ");
                                name = sc.next();
                                System.out.println("Enter new age: ");
                                int age = sc.nextInt();
                                System.out.println("Enter new salary: ");
                                double salary = sc.nextDouble();
                                System.out.println("Enter new phone number: ");
                                phno = sc.next();
                                System.out.println("Enter new email: ");
                                email = sc.next();
                                employeeOperations.updateEmployee(updateId, name, age, salary, phno, email);
                            } else {
                                System.out.println("Access denied! Employees can only update their own details.");
                            }
                            break;
                        case 5:
                            if (loggedInUserRole.equalsIgnoreCase("Admin")) {
                                System.out.println("Enter the ID of the employee to delete: ");
                                int deleteId = sc.nextInt();
                                employeeOperations.deleteEmployee(deleteId, loggedInAdminId);
                            } else {
                                System.out.println("Access denied! Only Admin can delete employees.");
                            }
                            break;
                        case 6:
                            System.out.println("Exiting the application. Goodbye!");
                            return;
                        default:
                            System.out.println("Invalid choice! Please try again.");
                    }
                }
            }
        }
    }
}
