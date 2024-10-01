package EMS;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection createDBConnection() {
        Connection con = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database connection parameters
            String url = "jdbc:mysql://localhost:3306/EMS";
            String username = "Keerthana";
            String password = "Keerthana_2126";

            // Establish Connection
            con = DriverManager.getConnection(url, username, password);

            // Check if the connection is successful
            if (con != null) {
                System.out.println("Connection established successfully!");
            } else {
                System.out.println("Failed to establish connection.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }
    public static void main(String[] args) {
        createDBConnection();
    }
}



