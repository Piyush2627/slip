import java.sql.*;
import java.util.Scanner;

public class jslip24b {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            // Load driver & connect
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/emp", "root", "admin");

            while (true) {
                System.out.println("\n1.Insert 2.Update 3.Delete 4.Search 5.Display 6.Exit");
                System.out.print("Enter choice: ");
                int ch = sc.nextInt();

                switch (ch) {

                    case 1: // Insert
                        PreparedStatement ps1 = con.prepareStatement(
                            "INSERT INTO Emp VALUES(?,?,?,?)");

                        System.out.print("Enter ENo: ");
                        ps1.setInt(1, sc.nextInt());

                        System.out.print("Enter Name: ");
                        ps1.setString(2, sc.next());

                        System.out.print("Enter Salary: ");
                        ps1.setDouble(3, sc.nextDouble());

                        System.out.print("Enter Designation: ");
                        ps1.setString(4, sc.next());

                        ps1.executeUpdate();
                        System.out.println("Inserted!");
                        break;

                    case 2: // Update
                        PreparedStatement ps2 = con.prepareStatement(
                            "UPDATE Emp SET salary=? WHERE ENo=?");

                        System.out.print("Enter New Salary: ");
                        ps2.setDouble(1, sc.nextDouble());

                        System.out.print("Enter ENo: ");
                        ps2.setInt(2, sc.nextInt());

                        ps2.executeUpdate();
                        System.out.println("Updated!");
                        break;

                    case 3: // Delete
                        PreparedStatement ps3 = con.prepareStatement(
                            "DELETE FROM Emp WHERE ENo=?");

                        System.out.print("Enter ENo: ");
                        ps3.setInt(1, sc.nextInt());

                        ps3.executeUpdate();
                        System.out.println("Deleted!");
                        break;

                    case 4: // Search
                        PreparedStatement ps4 = con.prepareStatement(
                            "SELECT * FROM Emp WHERE ENo=?");

                        System.out.print("Enter ENo: ");
                        ps4.setInt(1, sc.nextInt());

                        ResultSet rs = ps4.executeQuery();
                        if (rs.next()) {
                            System.out.println(rs.getInt(1) + " " +
                                               rs.getString(2) + " " +
                                               rs.getDouble(3) + " " +
                                               rs.getString(4));
                        } else {
                            System.out.println("Not Found!");
                        }
                        break;

                    case 5: // Display
                        Statement st = con.createStatement();
                        ResultSet rs2 = st.executeQuery("SELECT * FROM Emp");

                        while (rs2.next()) {
                            System.out.println(rs2.getInt(1) + " " +
                                               rs2.getString(2) + " " +
                                               rs2.getDouble(3) + " " +
                                               rs2.getString(4));
                        }
                        break;

                    case 6:
                        con.close();
                        System.exit(0);
                }
                sc.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}