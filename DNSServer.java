// Experiment No. 10
// Title: Simulation of DNS using UDP sockets
// Name: DNSServer.java

import java.net.*;
import java.util.*;

public class DNSServer {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            Map<String, String> dnsTable = new HashMap<>();
            dnsTable.put("example.com", "93.184.216.34");
            dnsTable.put("google.com", "142.250.183.206");
            dnsTable.put("yahoo.com", "98.137.11.163");

            System.out.println("DNS Server is running...");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String domainName = new String(receivePacket.getData(), 0, receivePacket.getLength());

                String ipAddress = dnsTable.getOrDefault(domainName, "Domain not found");
                sendData = ipAddress.getBytes();

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress,
                        clientPort);
                serverSocket.send(sendPacket);

                serverSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
