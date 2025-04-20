// Experiment No. 8(c)
// Title: File Transfer Using TCP
// Name: FtpS.java

import java.io.*;
import java.net.*;

class FtpS {
    public static void main(String a[]) throws Exception {
        Socket s = null;
        ServerSocket ss = null;
        DataOutputStream sso = null;
        DataInputStream sin = null;
        ss = new ServerSocket(55555);
        System.out.println("waiting");
        s = ss.accept();
        sso = new DataOutputStream(s.getOutputStream());
        sin = new DataInputStream(s.getInputStream());
        FileOutputStream fos = new FileOutputStream("abc1.txt");
        int str1;
        while ((str1 = sin.read()) != -1) {
            fos.write((char) str1);
            System.out.println((char) str1);
        }
        sso.close();
        s.close();
        fos.close();
        ss.close();
    }
}