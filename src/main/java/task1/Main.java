package task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int port = 8082;
        Listener listener = new Listener(port);
        String host = "netology.homework";
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), false);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in))) {
            String msgName = in.readLine();
            System.out.println(msgName);
            String name = bReader.readLine();
            out.println(name);
            out.flush();
            Thread.sleep(1000);
            String msgAge = in.readLine();
            System.out.println(msgAge);
            String age = bReader.readLine();
            out.println(age);
            out.flush();
            Thread.sleep(1000);
            String msgWlcm = in.readLine();
            System.out.println(msgWlcm);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
