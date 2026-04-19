public class jslip15a implements Runnable {

    public void run() {
        try {
            for (char c = 'a'; c <= 'z'; c++) {
                System.out.println("Alphabet : " + c);
                Thread.sleep(2000); // Wait 2 seconds
            }
            System.out.println("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        jslip15a obj = new jslip15a();
        Thread t = new Thread(obj);
        t.start();
    }
}
