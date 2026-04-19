import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jslip8a {
    public static void main(String[] args) {
        // You can change 'testdb' to your actual database name where the employees
        // table exists.
        String url = "jdbc:mysql://localhost:3306/emp";
        String user = "root";
        String password = "admin";

        try {
            // Register MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection to the database
            Connection con = DriverManager.getConnection(url, user, password);

            // Execute query
            // Assuming table name is 'Employee' and the column for name is 'name'
            // The query uses LIKE 'A%' to find everything starting with A
            Statement stmt = con.createStatement();
            String query = "SELECT name FROM Employee WHERE name LIKE 'A%'";

            System.out.println("Fetching employees whose name starts with 'A'...");
            ResultSet rs = stmt.executeQuery(query);

            // Extract data from result set
            boolean hasRecords = false;
            while (rs.next()) {
                String empName = rs.getString("name");
                System.out.println("Employee Name: " + empName);
                hasRecords = true;
            }

            if (!hasRecords) {
                System.out.println("No employees found starting with 'A'.");
            }

            // Clean up environments
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            // Handle errors for Class.forName and standard SQL errors
            e.printStackTrace();
        }
    }
}
