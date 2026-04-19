import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jslip12a {

    // DB credentials (same as previous programs)
    static final String URL      = "jdbc:mysql://localhost:3306/emp";
    static final String USER     = "root";
    static final String PASSWORD = "admin";

    public static void main(String[] args) {
        // Change this to any table name you want to count records from
        String tableName = "Employee";

        try {
            // 1. Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            // 3. Create Statement
            Statement stmt = con.createStatement();

            // 4. Execute COUNT query
            String query = "SELECT COUNT(*) AS total FROM " + tableName;
            ResultSet rs = stmt.executeQuery(query);

            // 5. Display the result
            System.out.println("============================================");
            if (rs.next()) {
                int count = rs.getInt("total");
                System.out.println("Table Name      : " + tableName);
                System.out.println("Total Records   : " + count);
            }
            System.out.println("============================================");

            // 6. Clean up
            rs.close();
            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Database Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
