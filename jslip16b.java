import java.sql.*;
import java.util.Scanner;

public class jslip16b {

    static final String URL      = "jdbc:mysql://localhost:3306/emp";
    static final String USER     = "root";
    static final String PASSWORD = "admin";

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

        // Create table if not exists
        Statement stmt = con.createStatement();
        stmt.executeUpdate(
            "CREATE TABLE IF NOT EXISTS Student16 " +
            "(rno INT PRIMARY KEY, sname VARCHAR(50), per DOUBLE)"
        );

        // Accept 5 student records
        String query = "INSERT INTO Student16 (rno, sname, per) VALUES (?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(query);

        System.out.println("Enter details of 5 students:");
        System.out.println("-----------------------------");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter Roll No   : ");
            int rno = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name      : ");
            String sname = sc.nextLine();
            System.out.print("Enter Percentage: ");
            double per = sc.nextDouble();

            pst.setInt(1, rno);
            pst.setString(2, sname);
            pst.setDouble(3, per);
            pst.executeUpdate();
            System.out.println("Record " + i + " saved.\n");
        }

        // Display student with highest percentage
        ResultSet rs = stmt.executeQuery(
            "SELECT * FROM Student16 ORDER BY per DESC LIMIT 1"
        );

        System.out.println("====================================");
        System.out.println("Student with Highest Percentage:");
        System.out.println("====================================");
        if (rs.next()) {
            System.out.println("Roll No    : " + rs.getInt("rno"));
            System.out.println("Name       : " + rs.getString("sname"));
            System.out.println("Percentage : " + rs.getDouble("per") + "%");
        }
        System.out.println("====================================");

        rs.close();
        pst.close();
        stmt.close();
        con.close();
        sc.close();
    }
}
