// Experiment No. 7
// Client Side Date and Time program

import java.io.*;
import java.net.*;

public class DateTimeClient {
    public static void main(String[] args) {
        String host = "localhost"; // Server address
        int port = 12345; // Server port

        try (Socket socket = new Socket(host, port);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Read and print the date and time from the server
            String dateTime = in.readLine();
            System.out.println("Current Date and Time: " + dateTime);
        } catch (IOException e) {
            System.out.println("Error connecting to server: " + e.getMessage());
        }
    }
}