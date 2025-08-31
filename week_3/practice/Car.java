package week_3.practice;

import java.time.Year;

public class Car {
    String brand;
    String model;
    int year;
    String color;
    boolean isRunning;

    public Car(String brand, String model, int year, String color) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isRunning = false;
    }

    public void startEngine() {
        isRunning = true;
        System.out.println(brand + " " + model + " engine started!");
    }

    public void stopEngine() {
        isRunning = false;
        System.out.println(brand + " " + model + " engine stopped!");
    }

    public void displayInfo() {
        System.out.println("Car Info: " + brand + " " + model + " (" + year + "), Color: " + color + ", Running: " + isRunning);
    }

    public int getAge() {
        return Year.now().getValue() - year;
    }

    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Corolla", 2020, "White");
        Car car2 = new Car("Tesla", "Model 3", 2022, "Red");
        Car car3 = new Car("Ford", "Mustang", 2018, "Blue");

        car1.startEngine();
        car1.displayInfo();
        System.out.println("Car age: " + car1.getAge() + " years");

        car2.displayInfo();
        car2.startEngine();
        car2.stopEngine();

        car3.displayInfo();
    }
}
