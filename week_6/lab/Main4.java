package week_6.lab;

class Color {
    String name;
    Color(String name) {
        this.name = name;
        System.out.println("Color: " + name);
    }
}

class PrimaryColor extends Color {
    int intensity;
    PrimaryColor(String name, int intensity) {
        super(name);
        this.intensity = intensity;
        System.out.println("Primary Color with intensity: " + intensity);
    }
}

class RedColor extends PrimaryColor {
    String shade;
    RedColor(String name, int intensity, String shade) {
        super(name, intensity);
        this.shade = shade;
        System.out.println("Red Color Shade: " + shade);
    }
}

public class Main4 {
    public static void main(String[] args) {
        RedColor r = new RedColor("Red", 80, "Crimson");
    }
}
