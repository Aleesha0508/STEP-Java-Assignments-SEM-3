package week_8.homework;

// Topic 4: Interface Inheritance (Extending Interface)

interface Animal {
    void eat();
}

interface Pet extends Animal {
    void play();
}

class Dog implements Pet {
    @Override
    public void eat() {
        System.out.println("Dog eats dog food.");
    }

    @Override
    public void play() {
        System.out.println("Dog loves to play fetch.");
    }
}

public class InterfaceInheritanceDemo {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();
        d.play();
    }
}
