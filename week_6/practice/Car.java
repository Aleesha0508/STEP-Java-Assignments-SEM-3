package week_6.practice;

public class Car extends Vehicle {
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;

    public Car() {
        super();
        this.numberOfDoors = 4;
        this.fuelType = "Petrol";
        this.transmissionType = "Manual";
        System.out.println("Car default constructor called");
    }

    public Car(String brand, String model, int year, String engineType,
               int numberOfDoors, String fuelType, String transmissionType) {
        super(brand, model, year, engineType);
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        System.out.println("Car parameterized constructor called");
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Car-specific startup sequence initiated");
    }

    @Override
    public void displaySpecs() {
        super.displaySpecs();
        System.out.println("Doors: " + numberOfDoors);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Transmission: " + transmissionType);
    }

    public void openTrunk() {
        System.out.println("Trunk opened");
    }

    public void playRadio() {
        System.out.println("Radio playing music");
    }

    public static void main(String[] args) {
        Car defaultCar = new Car();
        defaultCar.start();
        defaultCar.displaySpecs();
        defaultCar.openTrunk();
        defaultCar.playRadio();
        defaultCar.stop();

        System.out.println();

        Car paramCar = new Car("Toyota", "Corolla", 2023, "Hybrid", 4, "Petrol", "Automatic");
        paramCar.start();
        paramCar.displaySpecs();
        System.out.println(paramCar.getVehicleInfo());
        paramCar.stop();
    }
}
