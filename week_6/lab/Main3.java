package week_6.lab;

class Bird {
    void fly() {
        System.out.println("Bird is flying");
    }
}

class Penguin extends Bird {
    @Override
    void fly() {
        System.out.println("Penguin cannot fly, swims instead");
    }
}

class Eagle extends Bird {
    @Override
    void fly() {
        System.out.println("Eagle soars high");
    }
}

public class Main3 {
    public static void main(String[] args) {
        Bird[] birds = { new Penguin(), new Eagle() };
        for (Bird b : birds) b.fly();
    }
}

