





























































































































































































































































































































































import java.sql.*;

public class jslip20a {

    static final String URL = "jdbc:mysql://localhost:3306/emp";
    static final String USER = "root";
    static final String PASSWORD = "admin";

    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            System.out.println("Usage: java jslip20a <EmployeeID>");
            return;
        }

        int eno = Integer.parseInt(args[0]);

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

        PreparedStatement selectPst = con.prepareStatement(
                "SELECT * FROM Employee WHERE eno = ?");
        selectPst.setInt(1, eno);
        ResultSet rs = selectPst.executeQuery();

        if (!rs.next()) {
            System.out.println("No employee found with ENo: " + eno);
            con.close();
            return;
        }

        System.out.println("==========================================");
        System.out.println("Employee Found:");
        System.out.println("ENo    : " + rs.getInt("eno"));
        System.out.println("EName  : " + rs.getString("ename"));
        System.out.println("Salary : " + rs.getDouble("salary"));
        System.out.println("==========================================");

        PreparedStatement deletePst = con.prepareStatement(
                "DELETE FROM Employee WHERE eno = ?");
        deletePst.setInt(1, eno);
        int rows = deletePst.executeUpdate();

        if (rows > 0)
            System.out.println("Employee with ENo " + eno + " deleted successfully!");
        else
            System.out.println("Delete failed!");

        rs.close();
        selectPst.close();
        deletePst.close();
        con.close();
    }
}
