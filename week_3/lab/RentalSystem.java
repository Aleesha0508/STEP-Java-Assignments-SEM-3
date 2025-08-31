package week_3.lab;

class Vehicle {
    private String vehicleId, brand, model;
    private double rentPerDay;
    private boolean isAvailable;
    private static int totalVehicles = 0;
    private static double totalRevenue = 0;
    private static String companyName = "Default Rentals";
    private static int counter = 0;

    public Vehicle(String brand, String model, double rentPerDay) {
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.isAvailable = true;
        this.vehicleId = generateVehicleId();
        totalVehicles++;
    }

    private static String generateVehicleId() {
        counter++;
        return "V" + String.format("%03d", counter);
    }

    public void rentVehicle(int days) {
        if (isAvailable) {
            isAvailable = false;
            double cost = calculateRent(days);
            totalRevenue += cost;
            System.out.println(model + " rented for " + days + " days. Cost: " + cost);
        } else {
            System.out.println(model + " not available.");
        }
    }

    public void returnVehicle() {
        isAvailable = true;
    }

    public double calculateRent(int days) {
        return rentPerDay * days;
    }

    public void displayVehicleInfo() {
        System.out.println("ID: " + vehicleId + ", " + brand + " " + model + ", Rent/Day: " + rentPerDay + ", Available: " + isAvailable);
    }

    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static void displayCompanyStats() {
        System.out.println("Company: " + companyName + ", Total Vehicles: " + totalVehicles + ", Total Revenue: " + totalRevenue);
    }
}

public class RentalSystem {
    public static void main(String[] args) {
        Vehicle.setCompanyName("Spark Rentals");

        Vehicle v1 = new Vehicle("Toyota", "Innova", 2000);
        Vehicle v2 = new Vehicle("Honda", "City", 1500);

        v1.rentVehicle(3);
        v2.rentVehicle(2);

        v1.displayVehicleInfo();
        v2.displayVehicleInfo();

        Vehicle.displayCompanyStats();
    }
}
