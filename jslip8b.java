import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class jslip8b extends JFrame implements Runnable {
    private JLabel timeLabel;
    private Thread t;

    public jslip8b() {
        super("Digital Watch");
        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 40, 30));
        setResizable(false);

        // Styling the time label to look like a digital watch
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Digital-7", Font.BOLD, 40)); 
        // Fallback to Monospaced if Digital-7 isn't installed
        if (timeLabel.getFont().getFamily().equals(Font.DIALOG)) {
             timeLabel.setFont(new Font("Monospaced", Font.BOLD, 40));
        }
        timeLabel.setForeground(Color.GREEN);
        timeLabel.setOpaque(true);
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Add label to frame and set background to dark
        getContentPane().setBackground(Color.DARK_GRAY);
        add(timeLabel);

        // Start the thread for the watch
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Get current time format using SimpleDateFormat
                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss a");
                Date date = new Date();
                String timeString = formatter.format(date);

                // Update the Swing component safely
                SwingUtilities.invokeLater(() -> {
                    timeLabel.setText(timeString);
                });

                // Sleep for 1 second
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Watch thread interrupted: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Run completely within Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(() -> {
            jslip8b watch = new jslip8b();
            watch.setVisible(true);
        });
    }
}
