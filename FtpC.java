// Experiment No. 8(c)
// Title: File Transfer Using TCP
// Name: FtpC.java

import java.io.*;
import java.net.*;

public class FtpC {
    public static void main(String a[]) throws IOException {
        Socket s = null;
        DataInputStream si = null;
        s = new Socket("localhost", 55555);
        si = new DataInputStream(s.getInputStream());
        DataInputStream inp = new DataInputStream(System.in);
        DataOutputStream so = new DataOutputStream(s.getOutputStream());
        String str;
        System.out.println("enter the file name(path)");
        str = inp.readLine();
        int i;
        FileInputStream fos = new FileInputStream(str);
        while ((i = fos.read()) != -1)
            so.writeBytes(" " + (char) i);
        si.close();
        s.close();
        fos.close();
    }
}
