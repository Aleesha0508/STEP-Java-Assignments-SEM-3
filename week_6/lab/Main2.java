package week_6.lab;
class Phone {
    String brand, model;

    Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
        System.out.println("Phone constructor: " + brand + " " + model);
    }
}

class SmartPhone extends Phone {
    String operatingSystem;

    SmartPhone(String brand, String model, String os) {
        super(brand, model);
        this.operatingSystem = os;
        System.out.println("SmartPhone constructor: " + os);
    }
}

public class Main2 {
    public static void main(String[] args) {
        SmartPhone s = new SmartPhone("Apple", "iPhone 15", "iOS");
    }
}
