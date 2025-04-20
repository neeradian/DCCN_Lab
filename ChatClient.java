// Experiment No. 8(b)
// Title: Chat Application Using TCP
// Name: ChatClient.java

import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String args[]) throws Exception {
        Socket c = null;
        DataInputStream uin = null;
        DataInputStream din = null;
        DataOutputStream dout = null;
        try {
            c = new Socket("localhost", 68);
            uin = new DataInputStream(System.in);
            din = new DataInputStream(c.getInputStream());
            dout = new DataOutputStream(c.getOutputStream());
        } catch (Exception e) {
        }
        if (c != null) {
            String inp;
            System.out.println("Enter the message:");
            while ((inp = uin.readLine()) != null) {
                dout.writeBytes("" + inp);
                dout.writeBytes("\n");
                System.out.println("Echoed message from server.." + din.readLine());
                System.out.println("Enter ur message:");
            }
        }
        din.close();
        dout.close();
        c.close();
    }
}
