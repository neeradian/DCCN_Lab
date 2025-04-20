// Experiment No. 9
// Title: Simulation of Flow Monitor for Traffic Flow Simulation
// Name: TrafficFlowSimulation.java

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Vehicle {

    private String id;
    private int speed; // speed in km/h
    private long arrivalTime; // arrival time in milliseconds

    public Vehicle(String id, int speed, long arrivalTime) {
        this.id = id;
        this.speed = speed;
        this.arrivalTime = arrivalTime;
    }

    public int getSpeed() {
        return speed;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "Vehicle { id = '" + id + "', speed = " + speed + ", arrivalTime = " + arrivalTime + " }";
    }
}

class Road {

    private Queue<Vehicle> vehicles;
    private long monitoringStartTime;
    private int totalVehicles;
    private int totalSpeed;

    public Road() {
        this.vehicles = new LinkedList<>();
        this.monitoringStartTime = System.currentTimeMillis();
        this.totalVehicles = 0;
        this.totalSpeed = 0;
    }

    // Simulate vehicle arrival
    public void vehicleArrives(Vehicle vehicle) {
        vehicles.add(vehicle);
        totalVehicles++;
        totalSpeed += vehicle.getSpeed();
    }

    // Calculate average speed
    public double getAverageSpeed() {
        if (totalVehicles == 0) {
            return 0;
        }
        return (double) totalSpeed / totalVehicles;
    }

    // Calculate congestion (vehicles per minute)
    public double getCongestion() {
        long timeElapsed = System.currentTimeMillis() - monitoringStartTime; // in milliseconds
        double minutesElapsed = timeElapsed / 60000.0; // convert to minutes
        return totalVehicles / minutesElapsed; // vehicles per minute
    }

    public int getTotalVehicles() {
        return totalVehicles;
    }

    public int getTotalSpeed() {
        return totalSpeed;
    }
}

class TrafficFlowMonitor {

    private Road road;

    public TrafficFlowMonitor(Road road) {

        this.road = road;
    }

    // Display current flow statistics
    public void displayFlowStats() {
        System.out.println("Total Vehicles:" + road.getTotalVehicles());
        System.out.println("Average Speed:" + road.getAverageSpeed() + "km/h");
        System.out.println("Congestion(vehicles per minute):" + road.getCongestion());
    }

    // Simulate the arrival of a vehicle
    public void simulateVehicleArrival() {
        Random rand = new Random();
        int speed = rand.nextInt(100) + 20; // Random speed between 20 km/h to 120 km/h
        long arrivalTime = System.currentTimeMillis();
        Vehicle vehicle = new Vehicle("V" + (road.getTotalVehicles() + 1), speed, arrivalTime);
        road.vehicleArrives(vehicle);
        System.out.println("Vehicle " + vehicle + " arrived.");
    }
}

public class TrafficFlowSimulation {

    public static void main(String[] args) {
        Road road = new Road();
        TrafficFlowMonitor monitor = new TrafficFlowMonitor(road);

        // Simulate vehicle arrivals at random intervals
        for (int i = 0; i < 10; i++) {
            monitor.simulateVehicleArrival();
            try {
                Thread.sleep(1000); // Simulate 1 second interval between vehicle arrivals
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Display the traffic flow stats
        monitor.displayFlowStats();
    }
}
