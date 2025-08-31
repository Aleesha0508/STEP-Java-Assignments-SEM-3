package week_3.practice;

class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected double fuelLevel;

    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }

    public void startVehicle() { System.out.println(make + " " + model + " started."); }
    public void stopVehicle() { System.out.println(make + " " + model + " stopped."); }
    public void refuel(double amount) {
        fuelLevel += amount;
        System.out.println(make + " " + model + " refueled. Fuel: " + fuelLevel);
    }
    public void displayVehicleInfo() {
        System.out.println(year + " " + make + " " + model + ", Fuel Level: " + fuelLevel);
    }
}

class Car extends Vehicle {
    public Car(String make, String model, int year, double fuelLevel) {
        super(make, model, year, fuelLevel);
    }
}

class Truck extends Vehicle {
    public Truck(String make, String model, int year, double fuelLevel) {
        super(make, model, year, fuelLevel);
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String make, String model, int year, double fuelLevel) {
        super(make, model, year, fuelLevel);
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle v1 = new Car("Toyota", "Camry", 2020, 50);
        Vehicle v2 = new Truck("Ford", "F-150", 2019, 80);
        Vehicle v3 = new Motorcycle("Yamaha", "R15", 2022, 20);

        Vehicle[] vehicles = {v1, v2, v3};
        for (Vehicle v : vehicles) {
            v.startVehicle();
            v.displayVehicleInfo();
            v.refuel(10);
            v.stopVehicle();
        }
    }
}

