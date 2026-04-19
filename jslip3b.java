import javax.swing.*;
import java.awt.*;
import java.util.Random;

/*
 * jslip3b.java
 * Bouncing Ball using Swing (Applet removed in Java 21+, replaced with JPanel + JFrame)
 * Ball color changes randomly on each bounce.
 */
public class jslip3b extends JPanel implements Runnable {

    int x = 50, y = 50;       // Ball position
    int dx = 4, dy = 4;       // Ball speed/direction
    int diameter = 40;
    Color ballColor = Color.RED;
    Random rand = new Random();

    public jslip3b() {
        setBackground(Color.BLACK);
        new Thread(this).start();
    }

    public void run() {
        try {
            while (true) {
                // Move ball
                x += dx;
                y += dy;

                // Bounce off left/right walls
                if (x <= 0 || x + diameter >= getWidth()) {
                    dx = -dx;
                    ballColor = randomColor(); // Change color on bounce
                }

                // Bounce off top/bottom walls
                if (y <= 0 || y + diameter >= getHeight()) {
                    dy = -dy;
                    ballColor = randomColor(); // Change color on bounce
                }

                repaint();
                Thread.sleep(15); // ~60 FPS
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    // Generate a random bright color
    private Color randomColor() {
        return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(ballColor);
        g.fillOval(x, y, diameter, diameter);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Bouncing Ball");
        f.add(new jslip3b());
        f.setSize(500, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
