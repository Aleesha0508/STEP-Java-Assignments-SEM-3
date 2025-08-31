package week_3.homework;

import java.util.ArrayList;
import java.util.List;

class VehicleBase {
    protected String vehicleId;
    protected String brand;
    protected String model;
    protected int year;
    protected double mileage;
    protected String fuelType;
    protected String currentStatus;

    public static int totalVehicles = 0;
    public static double fleetValue = 0.0;
    public static String companyName = "TransCo";
    public static double totalFuelConsumption = 0.0;

    public VehicleBase(String id, String brand, String model, int year, double mileage, String fuelType) {
        this.vehicleId = id; this.brand = brand; this.model = model; this.year = year; this.mileage = mileage; this.fuelType = fuelType;
        this.currentStatus = "Available";
        totalVehicles++;
    }

    public void assignDriver(String driverId) { currentStatus = "Assigned to " + driverId; }
    public void scheduleMaintenance() { currentStatus = "Under Maintenance"; }
    public double calculateRunningCost(double distance, double fuelPricePerUnit) {
        double consumption = distance / 15.0; // assume 15 km/l
        totalFuelConsumption += consumption;
        return consumption * fuelPricePerUnit;
    }
}

class Car extends VehicleBase {
    public Car(String id, String brand, String model, int year, double mileage, String fuelType) { super(id,brand,model,year,mileage,fuelType); }
}

class Bus extends VehicleBase {
    private int seatingCapacity;
    public Bus(String id, String brand, String model, int year, double mileage, String fuelType, int seating) {
        super(id,brand,model,year,mileage,fuelType); this.seatingCapacity = seating;
    }
}

class Truck extends VehicleBase {
    private double loadCapacity;
    public Truck(String id, String brand, String model, int year, double mileage, String fuelType, double loadCap) {
        super(id,brand,model,year,mileage,fuelType); this.loadCapacity = loadCap;
    }
}

class Driver {
    public String driverId;
    public String driverName;
    public String licenseType;
    public String assignedVehicle;
    public int totalTrips;
    public Driver(String id,String name,String license) { driverId=id; driverName=name; licenseType=license; totalTrips=0; }
    public void assign(String vehicleId) { assignedVehicle = vehicleId; }
}

public class FleetManagementSystem {
    public static void main(String[] args) {
        List<VehicleBase> fleet = new ArrayList<>();
        fleet.add(new Car("V001","Toyota","Camry",2020,50000,"Petrol"));
        fleet.add(new Bus("V002","Volvo","B9",2018,120000,"Diesel",50));
        fleet.add(new Truck("V003","Tata","LPT",2019,90000,"Diesel",2000));

        Driver d1 = new Driver("D001","Ramesh","Heavy");
        d1.assign("V002");

        double cost = fleet.get(0).calculateRunningCost(150, 100); // 150 km, fuel price 100/unit
        System.out.println("Trip cost for " + fleet.get(0).vehicleId + ": " + cost);
        System.out.println("Total fuel consumed: " + VehicleBase.totalFuelConsumption);
    }
}
