





























































































































































































































































































































































import javax.swing.*;
import java.awt.*;

public class jslip20b extends JPanel implements Runnable {

    public jslip20b() {
        setBackground(new Color(135, 206, 235));
        new Thread(this).start();
    }

    public void run() {
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

g.setColor(new Color(139, 90, 43));
        g.fillRect(0, 280, 500, 20);

g.setColor(new Color(255, 228, 181));
        g.fillRect(130, 170, 200, 110);

g.setColor(new Color(101, 67, 33));
        g.fillRect(205, 210, 50, 70);

g.setColor(new Color(210, 180, 140));
        g.fillRect(140, 170, 20, 110);
        g.fillRect(300, 170, 20, 110);

g.setColor(new Color(205, 92, 92));
        g.fillRect(110, 150, 240, 25);

g.setColor(new Color(188, 74, 74));
        g.fillRect(135, 125, 190, 28);

g.setColor(new Color(170, 55, 55));
        g.fillRect(160, 100, 140, 28);

g.setColor(new Color(150, 40, 40));
        g.fillRect(185, 78, 90, 25);

g.setColor(new Color(255, 215, 0));
        int[] tx = {230, 215, 245};
        int[] ty = {40, 78, 78};
        g.fillPolygon(tx, ty, 3);

g.setColor(new Color(255, 215, 0));
        g.fillOval(223, 35, 15, 15);

g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString("Temple - Multithreading Drawing", 100, 320);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Temple Drawing");
        f.add(new jslip20b());
        f.setSize(460, 360);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
