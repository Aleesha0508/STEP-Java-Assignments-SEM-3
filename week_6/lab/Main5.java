package week_6.lab;

class Instrument {
    String name, material;
    Instrument(String name, String material) {
        this.name = name;
        this.material = material;
    }
    void play() {
        System.out.println("Playing instrument: " + name);
    }
}

class Piano extends Instrument {
    int keys;
    Piano(String name, String material, int keys) {
        super(name, material);
        this.keys = keys;
    }
    void play() {
        System.out.println("Playing Piano with " + keys + " keys");
    }
}

class Guitar extends Instrument {
    int strings;
    Guitar(String name, String material, int strings) {
        super(name, material);
        this.strings = strings;
    }
    void play() {
        System.out.println("Playing Guitar with " + strings + " strings");
    }
}

class Drum extends Instrument {
    String type;
    Drum(String name, String material, String type) {
        super(name, material);
        this.type = type;
    }
    void play() {
        System.out.println("Playing Drum of type: " + type);
    }
}

public class Main5 {
    public static void main(String[] args) {
        Instrument[] arr = {
            new Piano("Piano", "Wood", 88),
            new Guitar("Guitar", "Metal", 6),
            new Drum("Drum", "Plastic", "Bass")
        };
        for (Instrument i : arr) i.play();
    }
}

