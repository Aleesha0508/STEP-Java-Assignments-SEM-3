package week_6.homework;

class Weather {
    String condition;

    Weather(String condition) {
        this.condition = condition;
        System.out.println("Weather: " + condition);
    }

    void display() {
        System.out.println("General Weather: " + condition);
    }
}

class Storm extends Weather {
    int speed;

    Storm(String condition, int speed) {
        super(condition);
        this.speed = speed;
        System.out.println("Storm with speed " + speed + " km/h");
    }

    @Override
    void display() {
        System.out.println("Storm: " + condition + ", Speed: " + speed);
    }
}

class Thunderstorm extends Storm {
    boolean lightning;

    Thunderstorm(String condition, int speed, boolean lightning) {
        super(condition, speed);
        this.lightning = lightning;
        System.out.println("Thunderstorm, Lightning: " + lightning);
    }

    @Override
    void display() {
        System.out.println("Thunderstorm: " + condition + ", Speed: " + speed + ", Lightning: " + lightning);
    }
}

class Sunshine extends Weather {
    int temperature;

    Sunshine(String condition, int temperature) {
        super(condition);
        this.temperature = temperature;
        System.out.println("Sunshine at " + temperature + "°C");
    }

    @Override
    void display() {
        System.out.println("Sunshine: " + condition + ", Temp: " + temperature + "°C");
    }
}

public class HW6 {
    public static void main(String[] args) {
        Weather[] w = {
            new Storm("Rainy", 60),
            new Thunderstorm("Heavy Rain", 90, true),
            new Sunshine("Clear", 32)
        };
        for (Weather we : w) we.display();
    }
}
