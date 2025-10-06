package week_8.homework;

// Topic 3: Abstract Class + Interface Together

abstract class Vehicle {
    public abstract void start();

    public void stop() {
        System.out.println("Vehicle stopped.");
    }
}

interface Fuel {
    void refuel();
}

class Car extends Vehicle implements Fuel {
    @Override
    public void start() {
        System.out.println("Car started with key ignition.");
    }

    @Override
    public void refuel() {
        System.out.println("Car is refueling with petrol.");
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Car c = new Car();
        c.start();
        c.refuel();
        c.stop();
    }
}

