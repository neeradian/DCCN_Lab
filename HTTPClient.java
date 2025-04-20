// Experiment No. 6
// Webpage download using HTTP and TCP
// HTTPCLient.java

import java.io.*;
import java.net.*;

public class HTTPClient {
    public static void main(String[] args) {
        String hostName = "www.google.com";
        int portNumber = 80;
        try {
            Socket socket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("GET / HTTP/1.1\nHost: www.google.com\n\n");
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            
            socket.close();
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);
        }
    }
}
