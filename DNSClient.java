// Experiment No. 10
// Title: Simulation of DNS using UDP Sockets
// Name: DNSClient.java

import java.net.*;
import java.util.Scanner;

public class DNSClient {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            byte[] sendData;
            byte[] receiveData = new byte[1024];

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter domain name: ");
            String domainName = scanner.nextLine();
            sendData = domainName.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress,
                    9876);
            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            String ipAddress = new String(receivePacket.getData(), 0, receivePacket.getLength());

            System.out.println("IP Address: " + ipAddress);
            clientSocket.close();

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
