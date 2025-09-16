package week_6.homework;

abstract class Food {
    final void prepare() {
        wash();
        cook();
        serve();
    }
    abstract void wash();
    abstract void cook();
    abstract void serve();
}

class Pizza extends Food {
    void wash() { System.out.println("Washing ingredients for Pizza"); }
    void cook() { System.out.println("Baking Pizza"); }
    void serve() { System.out.println("Serving Pizza"); }
}

class Soup extends Food {
    void wash() { System.out.println("Washing vegetables for Soup"); }
    void cook() { System.out.println("Boiling Soup"); }
    void serve() { System.out.println("Serving Soup"); }
}

public class HW4 {
    public static void main(String[] args) {
        Food f1 = new Pizza();
        Food f2 = new Soup();
        f1.prepare();
        f2.prepare();
    }
}
