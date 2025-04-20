// Experiment No. 8(a)
// Title: Echo Server Program Using TCP
// Name: Secho.java

import java.io.*;
import java.net.*;

public class Secho {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(123);
        Socket s = ss.accept();
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        String str;
        System.out.println("\nSERVER SIDE!.........");

        while (true) {
            str = in.readLine();
            out.writeBytes(str + "\n");
            System.out.println("Msg from Client:");
            System.out.println(str + "\n");
        }

    }
}
