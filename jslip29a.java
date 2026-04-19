































































































































































































































































































































































class Odd extends Thread {
    int n;

    Odd(int n) {
        this.n = n;
    }

    public void run() {
        System.out.println("Odd Numbers:");
        for (int i = 1; i <= n; i++)
            if (i % 2 != 0)
                System.out.print(i + " ");
    }
}

class Prime extends Thread {
    int n;

    Prime(int n) {
        this.n = n;
    }

    public void run() {
        System.out.println("\nPrime Numbers:");
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                System.out.print(i + " ");
        }
    }
}

public class jslip29a {
    public static void main(String[] args) throws Exception {
        int n = 50;

        Odd t1 = new Odd(n);
        Prime t2 = new Prime(n);

        t1.start();
        t1.join(); 

        t2.start();
    }
}