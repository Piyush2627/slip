import java.util.Scanner;

public class jslip17a implements Runnable {

    String str;

    public jslip17a(String str) {
        this.str = str;
    }

    public void run() {
        try {
            System.out.println("Vowels in \"" + str + "\" :");
            for (int i = 0; i < str.length(); i++) {
                char c = Character.toLowerCase(str.charAt(i));
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    System.out.println(str.charAt(i));
                    Thread.sleep(3000); // Wait 3 seconds
                }
            }
            System.out.println("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String input = sc.nextLine();
        new Thread(new jslip17a(input)).start();
        sc.close();
    }
}
