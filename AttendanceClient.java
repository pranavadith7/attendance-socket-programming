import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class AttendanceClient {
    public static final String HOST = "127.0.0.1";
    public static final int PORT = 4444;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(HOST, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scin = new Scanner(System.in);
            String line = null;

            while (line == null || !line.equalsIgnoreCase("exit")) {
                line = scin.nextLine();
                System.out.println("Your input: " + line);
                out.println(line);
                out.flush();
                System.out.println("Reply from server: " + in.readLine());
            }
            scin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
