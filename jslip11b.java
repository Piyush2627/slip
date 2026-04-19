





























































































































































































































































































































































import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class jslip11b extends JFrame implements ActionListener {

    JTextField fromDateField, toDateField;
    JButton searchBtn;
    JTable table;
    DefaultTableModel tableModel;
    JLabel totalLabel;

    // DB credentials
    static final String URL = "jdbc:mysql://localhost:3306/emp";
    static final String USER = "root";
    static final String PASSWORD = "admin";

    public jslip11b() {
        super("Sales Details Between Two Dates");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        topPanel.setBackground(new Color(30, 30, 30));

        JLabel fromLabel = new JLabel("From Date (YYYY-MM-DD):");
        fromLabel.setForeground(Color.WHITE);
        fromDateField = new JTextField(12);

        JLabel toLabel = new JLabel("To Date (YYYY-MM-DD):");
        toLabel.setForeground(Color.WHITE);
        toDateField = new JTextField(12);

        searchBtn = new JButton("Search");
        searchBtn.setBackground(new Color(0, 150, 136));
        searchBtn.setForeground(Color.WHITE);
        searchBtn.setFocusPainted(false);
        searchBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        searchBtn.addActionListener(this);

        topPanel.add(fromLabel);
        topPanel.add(fromDateField);
        topPanel.add(toLabel);
        topPanel.add(toDateField);
        topPanel.add(searchBtn);

        String[] columns = { "PID", "PName", "Qty", "Rate", "Amount" };
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        table.setRowHeight(25);
        table.getTableHeader().setBackground(new Color(0, 150, 136));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        table.setFont(new Font("Arial", Font.PLAIN, 12));
        table.setGridColor(new Color(200, 200, 200));
        table.setSelectionBackground(new Color(178, 223, 219));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        bottomPanel.setBackground(new Color(45, 45, 45));
        totalLabel = new JLabel("Total Amount: ₹ 0.00");
        totalLabel.setForeground(Color.WHITE);
        totalLabel.setFont(new Font("Arial", Font.BOLD, 14));
        bottomPanel.add(totalLabel);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        getContentPane().setBackground(new Color(40, 40, 40));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fromDate = fromDateField.getText().trim();
        String toDate = toDateField.getText().trim();

        if (fromDate.isEmpty() || toDate.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter both From and To dates.",
                    "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        tableModel.setRowCount(0);
        double totalAmount = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            String query = "SELECT pid, pname, qty, rate, amount "
                    + "FROM Sales "
                    + "WHERE sale_date BETWEEN ? AND ?";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, fromDate);
            pst.setString(2, toDate);

            ResultSet rs = pst.executeQuery();
            boolean hasData = false;

            while (rs.next()) {
                int pid = rs.getInt("pid");
                String pname = rs.getString("pname");
                int qty = rs.getInt("qty");
                double rate = rs.getDouble("rate");
                double amount = rs.getDouble("amount");

                tableModel.addRow(new Object[] { pid, pname, qty, rate, amount });
                totalAmount += amount;
                hasData = true;
            }

            if (!hasData) {
                JOptionPane.showMessageDialog(this,
                        "No sales records found between the given dates.",
                        "No Data", JOptionPane.INFORMATION_MESSAGE);
            }

            totalLabel.setText(String.format("Total Amount: ₹ %.2f", totalAmount));

            rs.close();
            pst.close();
            con.close();

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this,
                    "MySQL JDBC Driver not found!\n" + ex.getMessage(),
                    "Driver Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                    "Database Error:\n" + ex.getMessage(),
                    "SQL Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new jslip11b().setVisible(true);
        });
    }
}
