import java.sql.*;

public class jslip26a {
    public static void main(String[] args) {
        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/your_db", "root", "password");

            // Create statement
            Statement st = con.createStatement();

            // Execute query
            ResultSet rs = st.executeQuery("SELECT CName FROM College");

            // Display names
            System.out.println("College Names:");
            while (rs.next()) {
                System.out.println(rs.getString("CName"));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}