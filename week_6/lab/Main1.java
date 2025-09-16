package week_6.lab;

class Fruit {
    protected String color;
    protected String taste;

    Fruit(String color, String taste) {
        this.color = color;
        this.taste = taste;
    }
}

class Apple extends Fruit {
    String variety;

    Apple(String color, String taste, String variety) {
        super(color, taste);
        this.variety = variety;
    }

    void display() {
        System.out.println("Apple Variety: " + variety + ", Color: " + color + ", Taste: " + taste);
    }
}

public class Main1 {
    public static void main(String[] args) {
        Apple a = new Apple("Red", "Sweet", "Fuji");
        a.display();
    }
}
