package week_7.homework;

public class FleetManagement {
    public static void main(String[] args) {
        Vehicle[] fleet = {new Bus(), new Taxi(), new Train(), new Bike()};
        for (Vehicle v : fleet) v.move();
    }
}
class Vehicle {
    void move() {
        System.out.println("Vehicle is moving");
    }
}
class Bus extends Vehicle {
    void move() {
        System.out.println("Bus follows fixed route with passengers");
    }
}
class Taxi extends Vehicle {
    void move() {
        System.out.println("Taxi providing door-to-door service");
    }
}
class Train extends Vehicle {
    void move() {
        System.out.println("Train moving on schedule with multiple cars");
    }
}
class Bike extends Vehicle {
    void move() {
        System.out.println("Bike available for short distance eco-trips");
    }
}

