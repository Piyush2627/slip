import java.net.*;
import java.io.*;
import java.util.Date;

// Run this first: java DateServer
class DateServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started. Waiting for client...");

        Socket s = ss.accept();
        System.out.println("Client connected!");

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.println(new Date().toString()); // Send current date & time

        s.close();
        ss.close();
        System.out.println("Date sent to client. Server closed.");
    }
}

// Run this second: java jslip22a
public class jslip22a {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(
            new InputStreamReader(s.getInputStream())
        );

        String dateTime = in.readLine();
        System.out.println("Date & Time from Server: " + dateTime);

        s.close();
    }
}
