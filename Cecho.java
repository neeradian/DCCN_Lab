// Experiment No. 8(a)
// Title: Echo Client Program Using TCP
// Name: Cecho.java

import java.io.*;
import java.net.*;

public class Cecho {
    public static void main(String args[]) throws Exception {
        DataInputStream in = new DataInputStream(System.in);
        Socket s = new Socket("LocalHost", 123);
        DataInputStream inecho = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        String str;
        System.out.println("\nCLIENT SIDE!...\nType EXIT TO QUIT\nEnter Client Msg");
        while ((str = in.readLine()) != null) {
            out.writeBytes(str + "\n");
            if (str.equals("exit")) {
                out.writeBytes("\nClient Terminated");
                break;
            } else {
                System.out.println("\nEcho From Server");
                System.out.print(str + "\n");
                System.out.println("\nCLIENT SIDE!...\nEnter Client Msg");
            }
        }
    }
}
