// Custom Thread class
class PrintThread extends Thread {

    public PrintThread(String name) {
        super(name); // Set thread name via constructor
    }

    @Override
    public void run() {
        // Thread.currentThread() gives a reference to the currently executing thread
        System.out.println("Currently Executing Thread : " + Thread.currentThread().getName());
        System.out.println("Thread ID                  : " + Thread.currentThread().threadId());
        System.out.println("Thread Priority            : " + Thread.currentThread().getPriority());
        System.out.println("Thread State               : " + Thread.currentThread().getState());
        System.out.println("-------------------------------------------------------");
    }
}

public class jslip13a {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("=======================================================");
        System.out.println("    Displaying Currently Executing Thread Names        ");
        System.out.println("=======================================================");
        System.out.println();

        // Display the main thread details first
        System.out.println("Currently Executing Thread : " + Thread.currentThread().getName());
        System.out.println("Thread ID                  : " + Thread.currentThread().threadId());
        System.out.println("Thread Priority            : " + Thread.currentThread().getPriority());
        System.out.println("Thread State               : " + Thread.currentThread().getState());
        System.out.println("-------------------------------------------------------");

        // Create multiple threads with hardcoded names
        PrintThread t1 = new PrintThread("Thread-One");
        PrintThread t2 = new PrintThread("Thread-Two");
        PrintThread t3 = new PrintThread("Thread-Three");

        // Start the threads
        t1.start();
        t2.start();
        t3.start();

        // Wait for all threads to finish before main exits
        t1.join();
        t2.join();
        t3.join();

        System.out.println();
        System.out.println("All threads finished execution.");
        System.out.println("=======================================================");
    }
}
