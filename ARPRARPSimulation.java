// Experiment No. 5
// ARP RARP Simulation Program

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

class ARP {

    private Map<String, String> arpTable; // Maps IP addresses to MAC addresses

    public ARP() {
        arpTable = new HashMap<>();
    }

    // Method to simulate ARP reqeust
    public String arpRequest(String ipAddress) {
        String macAddress = arpTable.get(ipAddress);
        if (macAddress != null)
            return "ARP Response: " + ipAddress + "is at " + macAddress;
        else
            return "ARP Response: " + ipAddress + "not found. ";
    }

    // Method to add a new entry to the ARP Table
    public void addEntry(String ipAddress, String macAddress) {
        arpTable.put(ipAddress, macAddress);
    }
}

class RARP {
    private Map<String, String> rarpTable; // Maps MAC addresses to IP addresses

    public RARP() {
        rarpTable = new HashMap<>();
    }

    // Method to simulate RARP request
    public String rarpRequest(String macAddress) {
        String ipAddress = rarpTable.get(macAddress);
        if (ipAddress != null)
            return "RARP Response: " + macAddress + "is at " + ipAddress;
        else
            return "RARP Response: " + macAddress + "not found. ";
    }

    // Method to add a new entry to the RARP table
    public void addEntry(String macAddress, String ipAddress) {
        rarpTable.put(macAddress, ipAddress);
    }
}

public class ARPRARPSimulation {

    public static void main(String[] args) {
        ARP arp = new ARP();
        RARP rarp = new RARP();
        Scanner scanner = new Scanner(System.in);

        // Sample Entries for ARP and RARP
        arp.addEntry("192.168.1.1", "00:0A:95:9D:68:16");
        rarp.addEntry("00:0A:95:9D:68:16", "192.168.1.1");

        // Simulate ARP Request
        System.out.print("Enter an IP address to resolve (ARP): ");
        String ipRequest = scanner.nextLine();
        String arpResponse = arp.arpRequest(ipRequest);
        System.out.println(arpResponse);

        // Simulate RARP Request
        System.out.print("Enter a MAC Address to resolve (RARP): ");
        String macRequest = scanner.nextLine();
        String rarpResponse = rarp.rarpRequest(macRequest);
        System.out.println(rarpResponse);

        scanner.close();
    }
}