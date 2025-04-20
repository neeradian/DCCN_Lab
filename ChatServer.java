// Experiment No. 8(b)
// Title: Chat Application Using TCP
// Name: ChatServer.java

import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String args[]) throws Exception {
        DataInputStream din = null;
        DataOutputStream dout = null;
        Socket c = null;
        ServerSocket m = null;
        DataInputStream stdin = new DataInputStream(System.in);
        try {
            m = new ServerSocket(68);
            c = m.accept();
            din = new DataInputStream(c.getInputStream());
            dout = new DataOutputStream(c.getOutputStream());
        } catch (Exception e) {
        }
        while (c != null) {
            String m2;
            System.out.println("Server");
            while (true) {
                String m1 = din.readLine();
                System.out.println("Message from client.." + m1);
                System.out.println("\n\n Enter the message...");
                m2 = stdin.readLine();
                dout.writeBytes("" + m2);
                dout.writeBytes("\n");
            }
        }
        din.close();
        dout.close();
        c.close();
        m.close();
    }
}
