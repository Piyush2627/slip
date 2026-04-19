import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jslip7b extends JFrame implements Runnable, ActionListener {
    private JTextField tf;
    private JButton btn;
    private Thread t;

    public jslip7b() {
        super("Number Display (1 to 100)");
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tf = new JTextField(10);
        tf.setEditable(false);
        tf.setFont(new Font("Arial", Font.BOLD, 18));
        tf.setHorizontalAlignment(JTextField.CENTER);

        btn = new JButton("Display Numbers");
        btn.addActionListener(this);

        add(new JLabel("Number:"));
        add(tf);
        add(btn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Start thread only if it's not already running
        if (t == null || !t.isAlive()) {
            t = new Thread(this);
            t.start();
        }
    }

    @Override
    public void run() {
        // Infinite loop to meet standard "continuous" phrasing in slips, or just 1 to 100 once.
        // We will just do a continuous cyclic loop from 1 to 100.
        // If the assignment just meant "1 to 100 sequentially", a single pass is enough.
        // Here we do continuous single pass, and if clicked again, it resets.
        for (int i = 1; i <= 100; i++) {
            tf.setText(String.valueOf(i));
            try {
                // Sleep for 100ms so the continuous updates are visible
                Thread.sleep(100); 
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }

    public static void main(String[] args) {
        jslip7b frame = new jslip7b();
        frame.setVisible(true);
    }
}
