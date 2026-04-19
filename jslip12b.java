import java.util.Random;

// Custom Thread class with name hardcoded via constructor
class MyThread extends Thread {

    private int sleepTime;
    private static final Random random = new Random();

    // Constructor: name is hardcoded here
    public MyThread(String name) {
        super(name); // Sets thread name via Thread constructor
        // Generate random sleep time between 0 and 4999
        sleepTime = random.nextInt(5000);
    }

    @Override
    public void run() {
        // ── RUNNING STATE ─────────────────────────────────────────────────
        System.out.println("Thread Name : " + getName()
                + " | State: " + getState()
                + " | Sleep Time: " + sleepTime + " ms");

        try {
            // ── SLEEP STATE ───────────────────────────────────────────────
            System.out.println("Thread Name : " + getName()
                    + " | Going to SLEEP for " + sleepTime + " ms...");
            Thread.sleep(sleepTime);

        } catch (InterruptedException e) {
            System.out.println("Thread Name : " + getName() + " | Interrupted!");
        }

        // ── ABOUT TO DIE ──────────────────────────────────────────────────
        System.out.println("Thread Name : " + getName()
                + " | Woke up. About to become DEAD (TERMINATED).");
    }
}

public class jslip12b {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("=======================================================");
        System.out.println("      Thread Lifecycle Demo: Creation → Sleep → Dead   ");
        System.out.println("=======================================================\n");

        // ── CREATE THREADS (NEW STATE) ────────────────────────────────────────
        // Thread names are hardcoded via constructor
        MyThread t1 = new MyThread("Alpha");
        MyThread t2 = new MyThread("Beta");
        MyThread t3 = new MyThread("Gamma");

        System.out.println("[CREATED]  " + t1.getName() + " | State: " + t1.getState());
        System.out.println("[CREATED]  " + t2.getName() + " | State: " + t2.getState());
        System.out.println("[CREATED]  " + t3.getName() + " | State: " + t3.getState());
        System.out.println();

        // ── START THREADS (RUNNABLE STATE) ────────────────────────────────────
        System.out.println("[STARTING THREADS...]\n");
        t1.start();
        t2.start();
        t3.start();

        // Wait for all threads to finish
        t1.join();
        t2.join();
        t3.join();

        // ── ALL THREADS DEAD (TERMINATED STATE) ───────────────────────────────
        System.out.println();
        System.out.println("[TERMINATED]  " + t1.getName() + " | State: " + t1.getState());
        System.out.println("[TERMINATED]  " + t2.getName() + " | State: " + t2.getState());
        System.out.println("[TERMINATED]  " + t3.getName() + " | State: " + t3.getState());
        System.out.println();
        System.out.println("=======================================================");
        System.out.println("         All threads are now DEAD. Program Ends.       ");
        System.out.println("=======================================================");
    }
}
