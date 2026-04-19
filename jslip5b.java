import javax.swing.*;
import java.awt.*;

public class jslip5b extends JPanel implements Runnable {

    Thread t;
    String signal = "RED";

    public jslip5b() {
        t = new Thread(this);
        t.start();
    }

    public void run() {
        try {
            while (true) {
                signal = "RED";
                repaint();
                Thread.sleep(3000);

                signal = "GREEN";
                repaint();
                Thread.sleep(3000);

                signal = "YELLOW";
                repaint();
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw box
        g.setColor(Color.black);
        g.fillRect(100, 50, 100, 250);

        // Lights
        if (signal.equals("RED")) {
            g.setColor(Color.red);
            g.fillOval(120, 60, 60, 60);
        } else {
            g.setColor(Color.gray);
            g.fillOval(120, 60, 60, 60);
        }

        if (signal.equals("YELLOW")) {
            g.setColor(Color.yellow);
            g.fillOval(120, 130, 60, 60);
        } else {
            g.setColor(Color.gray);
            g.fillOval(120, 130, 60, 60);
        }

        if (signal.equals("GREEN")) {
            g.setColor(Color.green);
            g.fillOval(120, 200, 60, 60);
        } else {
            g.setColor(Color.gray);
            g.fillOval(120, 200, 60, 60);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Traffic Light Simulation");
        jslip5b panel = new jslip5b();
        frame.add(panel);
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}