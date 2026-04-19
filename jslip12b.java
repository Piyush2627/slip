





























































































































































































































































































































































import java.util.Random;

class MyThread extends Thread {

    private int sleepTime;
    private static final Random random = new Random();

public MyThread(String name) {
        super(name); 
        
        sleepTime = random.nextInt(5000);
    }

    @Override
    public void run() {
        
        System.out.println("Thread Name : " + getName()
                + " | State: " + getState()
                + " | Sleep Time: " + sleepTime + " ms");

        try {
            
            System.out.println("Thread Name : " + getName()
                    + " | Going to SLEEP for " + sleepTime + " ms...");
            Thread.sleep(sleepTime);

        } catch (InterruptedException e) {
            System.out.println("Thread Name : " + getName() + " | Interrupted!");
        }

System.out.println("Thread Name : " + getName()
                + " | Woke up. About to become DEAD (TERMINATED).");
    }
}

public class jslip12b {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("=======================================================");
        System.out.println("      Thread Lifecycle Demo: Creation → Sleep → Dead   ");
        System.out.println("=======================================================\n");

MyThread t1 = new MyThread("Alpha");
        MyThread t2 = new MyThread("Beta");
        MyThread t3 = new MyThread("Gamma");

        System.out.println("[CREATED]  " + t1.getName() + " | State: " + t1.getState());
        System.out.println("[CREATED]  " + t2.getName() + " | State: " + t2.getState());
        System.out.println("[CREATED]  " + t3.getName() + " | State: " + t3.getState());
        System.out.println();

System.out.println("[STARTING THREADS...]\n");
        t1.start();
        t2.start();
        t3.start();

t1.join();
        t2.join();
        t3.join();

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
