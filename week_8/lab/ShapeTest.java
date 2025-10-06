package week_8.lab;

// LAB PROBLEM 2: Abstract Shape and Drawable Interface

abstract class Shape {
    protected double area;
    protected double perimeter;

    public abstract void calculateArea();
    public abstract void calculatePerimeter();
}

interface Drawable {
    void draw();
}

class Circle extends Shape implements Drawable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
        area = Math.PI * radius * radius;
    }

    @Override
    public void calculatePerimeter() {
        perimeter = 2 * Math.PI * radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius: " + radius);
    }

    public void showDetails() {
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        Circle c = new Circle(5);
        c.calculateArea();
        c.calculatePerimeter();
        c.draw();
        c.showDetails();
    }
}
