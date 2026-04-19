import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;

public class jslip27b extends JPanel implements Runnable {
    private Thread t;
    private int stripeY = 0; // Animation position
    private boolean running = false;

    public jslip27b() {
        setBackground(Color.white);
        start();
    }

    public void start() {
        if (t == null) {
            running = true;
            t = new Thread(this);
            t.start();
        }
    }

    @Override
    public void run() {
        try {
            while (running) {
                stripeY += 5;
                if (getHeight() > 0 && stripeY > getHeight()) {
                    stripeY = 0;
                }
                repaint();
                Thread.sleep(100); // Control animation speed
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int height = getHeight();

        // Draw flag pole
        g.setColor(Color.DARK_GRAY);
        g.fillRect(50, 50, 10, height - 100);

        // Draw flag (Indian tricolor example)
        int flagX = 60;
        int flagY = 50;
        int flagWidth = 200;
        int flagHeight = 120;

        // Saffron stripe
        g.setColor(Color.ORANGE);
        g.fillRect(flagX, flagY, flagWidth, flagHeight / 3);

        // White stripe
        g.setColor(Color.WHITE);
        g.fillRect(flagX, flagY + flagHeight / 3, flagWidth, flagHeight / 3);

        // Green stripe
        g.setColor(Color.GREEN);
        g.fillRect(flagX, flagY + 2 * flagHeight / 3, flagWidth, flagHeight / 3);

        // Ashoka Chakra (simple circle)
        g.setColor(Color.BLUE);
        g.drawOval(flagX + flagWidth / 2 - 15, flagY + flagHeight / 3 + 5, 30, 30);

        // Simple animation: moving stripe
        g.setColor(new Color(0, 0, 255, 80)); // Transparent blue
        g.fillRect(flagX, stripeY, flagWidth, 5);
    }

    public void stop() {
        running = false;
        t = null;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flag Applet to Swing");
        jslip27b panel = new jslip27b();
        frame.add(panel);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
