package task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Listener extends Thread {
    int port;

    public Listener(int port) {
        this.port = port;
        this.start();
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), false);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("New connection accepted");
            out.println("Write your name");
            out.flush();
            String name = in.readLine();
            out.println("Are you child? (yes/no)");
            out.flush();
            String age = in.readLine();
            if (age.equals("yes")) {
                out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
            } else if (age.equals("no")) {
                out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
