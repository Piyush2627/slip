





























































































































































































































































































































































import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class jslip19b extends JFrame implements ActionListener {

    JTextField rnoField, snameField, perField;
    JButton fetchBtn;

    static final String URL = "jdbc:mysql://localhost:3306/emp";
    static final String USER = "root";
    static final String PASSWORD = "admin";

    public jslip19b() {
        super("Display First Student Record");
        setSize(350, 250);
        setLayout(new GridLayout(4, 2, 10, 15));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new JLabel("  Roll No :"));
        rnoField = new JTextField();
        add(rnoField);

        add(new JLabel("  Name :"));
        snameField = new JTextField();
        add(snameField);

        add(new JLabel("  Percentage :"));
        perField = new JTextField();
        add(perField);

        fetchBtn = new JButton("Fetch First Record");
        fetchBtn.addActionListener(this);
        add(new JLabel());
        add(fetchBtn);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Student LIMIT 1");

            if (rs.next()) {
                rnoField.setText(String.valueOf(rs.getInt("rno")));
                snameField.setText(rs.getString("sname"));
                perField.setText(String.valueOf(rs.getDouble("per")));
            } else {
                JOptionPane.showMessageDialog(this, "No records found!");
            }

            rs.close();
            con.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new jslip19b().setVisible(true);
    }
}
