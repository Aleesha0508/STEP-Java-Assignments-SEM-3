package week_8.lab;

// LAB PROBLEM 1: Abstract Fruit and Edible Interface

abstract class Fruit {
    protected String color;
    protected String taste;

    public Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }

    // Abstract method
    public abstract void showDetails();
}

interface Edible {
    void nutrientsInfo();
}

class Apple extends Fruit implements Edible {
    private String variety;

    public Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
    }

    @Override
    public void showDetails() {
        System.out.println("Apple Variety: " + variety);
        System.out.println("Color: " + color);
        System.out.println("Taste: " + taste);
    }

    @Override
    public void nutrientsInfo() {
        System.out.println("Nutrients: Rich in fiber and Vitamin C");
    }
}

public class FruitTest {
    public static void main(String[] args) {
        Apple a = new Apple("Red", "Sweet", "Fuji");
        a.showDetails();
        a.nutrientsInfo();
    }
}
