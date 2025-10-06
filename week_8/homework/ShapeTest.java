package week_8.homework;

// Topic 1: Abstract Class with Abstract and Concrete Methods

abstract class Shape {
    // Abstract methods
    public abstract double area();
    public abstract double perimeter();

    // Concrete method
    public void displayInfo() {
        System.out.println("This is a geometric shape.");
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        circle.displayInfo();
        System.out.println("Circle Area: " + circle.area());
        System.out.println("Circle Perimeter: " + circle.perimeter());

        Shape rect = new Rectangle(4, 6);
        rect.displayInfo();
        System.out.println("Rectangle Area: " + rect.area());
        System.out.println("Rectangle Perimeter: " + rect.perimeter());
    }
}
