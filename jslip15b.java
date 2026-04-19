import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class jslip15b extends JFrame implements ActionListener {

    // Swing Components
    JTextField rnoField, snameField, perField;
    JRadioButton maleBtn, femaleBtn;
    ButtonGroup genderGroup;
    JComboBox<String> classBox;
    JButton saveBtn, clearBtn;
    JLabel statusLabel;

    // DB credentials
    static final String URL      = "jdbc:mysql://localhost:3306/emp";
    static final String USER     = "root";
    static final String PASSWORD = "admin";

    public jslip15b() {
        super("Student Registration Form");
        setSize(420, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 250));

        // ── Title Label ───────────────────────────────────────────────────────
        JLabel title = new JLabel("Student Registration", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setForeground(new Color(33, 97, 140));
        title.setBounds(0, 10, 420, 30);
        add(title);

        // ── Roll No ───────────────────────────────────────────────────────────
        addLabel("Roll No   :", 30, 60);
        rnoField = new JTextField();
        rnoField.setBounds(160, 60, 200, 28);
        add(rnoField);

        // ── Student Name ──────────────────────────────────────────────────────
        addLabel("Name       :", 30, 105);
        snameField = new JTextField();
        snameField.setBounds(160, 105, 200, 28);
        add(snameField);

        // ── Percentage ───────────────────────────────────────────────────────
        addLabel("Percentage :", 30, 150);
        perField = new JTextField();
        perField.setBounds(160, 150, 200, 28);
        add(perField);

        // ── Gender (Radio Buttons) ───────────────────────────────────────────
        addLabel("Gender     :", 30, 195);
        maleBtn   = new JRadioButton("Male");
        femaleBtn = new JRadioButton("Female");
        maleBtn.setBackground(new Color(245, 245, 250));
        femaleBtn.setBackground(new Color(245, 245, 250));
        maleBtn.setBounds(160, 195, 80, 28);
        femaleBtn.setBounds(250, 195, 90, 28);
        genderGroup = new ButtonGroup();
        genderGroup.add(maleBtn);
        genderGroup.add(femaleBtn);
        maleBtn.setSelected(true);
        add(maleBtn);
        add(femaleBtn);

        // ── Class (ComboBox) ─────────────────────────────────────────────────
        addLabel("Class      :", 30, 240);
        classBox = new JComboBox<>(new String[]{"FY", "SY", "TY"});
        classBox.setBounds(160, 240, 200, 28);
        add(classBox);

        // ── Buttons ───────────────────────────────────────────────────────────
        saveBtn = new JButton("Save");
        saveBtn.setBounds(80, 295, 100, 32);
        saveBtn.setBackground(new Color(33, 97, 140));
        saveBtn.setForeground(Color.WHITE);
        saveBtn.setFocusPainted(false);
        saveBtn.addActionListener(this);
        add(saveBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(220, 295, 100, 32);
        clearBtn.setBackground(new Color(150, 150, 150));
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setFocusPainted(false);
        clearBtn.addActionListener(this);
        add(clearBtn);

        // ── Status Label ─────────────────────────────────────────────────────
        statusLabel = new JLabel("", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        statusLabel.setBounds(0, 335, 420, 25);
        add(statusLabel);
    }

    // Helper to add labels
    private void addLabel(String text, int x, int y) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(new Font("Arial", Font.PLAIN, 13));
        lbl.setBounds(x, y, 130, 28);
        add(lbl);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearBtn) {
            rnoField.setText("");
            snameField.setText("");
            perField.setText("");
            maleBtn.setSelected(true);
            classBox.setSelectedIndex(0);
            statusLabel.setText("");
            return;
        }

        // ── Save Button ────────────────────────────────────────────────────
        String rno   = rnoField.getText().trim();
        String sname = snameField.getText().trim();
        String per   = perField.getText().trim();
        String gender = maleBtn.isSelected() ? "Male" : "Female";
        String cls   = (String) classBox.getSelectedItem();

        // Validation
        if (rno.isEmpty() || sname.isEmpty() || per.isEmpty()) {
            statusLabel.setForeground(Color.RED);
            statusLabel.setText("Please fill all fields!");
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create table if not exists
            Statement stmt = con.createStatement();
            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS Student (" +
                "RNo INT PRIMARY KEY, SName VARCHAR(50), " +
                "Per DOUBLE, Gender VARCHAR(10), Class VARCHAR(5))"
            );

            // Insert using PreparedStatement
            String query = "INSERT INTO Student (RNo, SName, Per, Gender, Class) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(rno));
            pst.setString(2, sname);
            pst.setDouble(3, Double.parseDouble(per));
            pst.setString(4, gender);
            pst.setString(5, cls);
            pst.executeUpdate();

            statusLabel.setForeground(new Color(0, 128, 0));
            statusLabel.setText("Record saved successfully!");

            pst.close();
            con.close();

        } catch (NumberFormatException ex) {
            statusLabel.setForeground(Color.RED);
            statusLabel.setText("RNo and Percentage must be numeric!");
        } catch (SQLIntegrityConstraintViolationException ex) {
            statusLabel.setForeground(Color.RED);
            statusLabel.setText("Roll No already exists!");
        } catch (Exception ex) {
            statusLabel.setForeground(Color.RED);
            statusLabel.setText("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new jslip15b().setVisible(true));
    }
}
