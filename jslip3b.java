





























































































































































































































































































































































import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class jslip3b extends JPanel implements Runnable {

    int x = 50, y = 50;       
    int dx = 4, dy = 4;       
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
                
                x += dx;
                y += dy;

if (x <= 0 || x + diameter >= getWidth()) {
                    dx = -dx;
                    ballColor = randomColor(); 
                }

if (y <= 0 || y + diameter >= getHeight()) {
                    dy = -dy;
                    ballColor = randomColor(); 
                }

                repaint();
                Thread.sleep(15); 
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

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
