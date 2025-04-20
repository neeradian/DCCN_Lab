// Experiment No. 7
// Server Side Date and Time program

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeServer {
    public static void main(String[] args) {
        int port = 12345; // Port number to listen on

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("DateTime Server is running on port " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("Client connected: " + clientSocket.getInetAddress());

                    // Get the current date and time
                    String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

                    // Send the current date and time to the client
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    out.println(currentDateTime);

                    System.out.println("Sent date and time to client: " + currentDateTime);
                } catch (IOException e) {
                    System.out.println("Error handling client: " + e.getMessage());
                }
            }
            
        } catch (IOException e) {
            System.out.println("Could not listen on port: " + port);
            e.printStackTrace();
        }
    }
}