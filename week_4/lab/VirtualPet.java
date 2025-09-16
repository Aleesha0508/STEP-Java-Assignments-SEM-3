package week_4.lab;

import java.util.*;

public class VirtualPet {
    // === Fields ===
    private final String petId; // unique ID
    private String petName;
    private String species;
    private int age;
    private int happiness;
    private int health;
    private String stage;

    private static final String[] EVOLUTION_STAGES = {"Egg", "Baby", "Child", "Teen", "Adult", "Elder"};
    private static int totalPetsCreated = 0;

    // === Main constructor (all fields) ===
    public VirtualPet(String petName, String species, int age, int happiness, int health, String stage) {
        this.petId = generatePetId();
        this.petName = petName;
        this.species = species;
        this.age = age;
        this.happiness = happiness;
        this.health = health;
        this.stage = stage;
        totalPetsCreated++;
    }

    // === Default constructor: mysterious egg ===
    public VirtualPet() {
        this("Unknown", getRandomSpecies(), 0, 50, 50, EVOLUTION_STAGES[0]);
    }

    // === Constructor with name only: baby ===
    public VirtualPet(String petName) {
        this(petName, getRandomSpecies(), 1, 60, 60, EVOLUTION_STAGES[1]);
    }

    // === Constructor with name + species: child ===
    public VirtualPet(String petName, String species) {
        this(petName, species, 3, 70, 70, EVOLUTION_STAGES[2]);
    }

    // === Actions ===
    public void feedPet() {
        if (isDead()) return;
        health = Math.min(100, health + 10);
        System.out.println(petName + " enjoyed the meal! Health: " + health);
    }

    public void playWithPet() {
        if (isDead()) return;
        happiness = Math.min(100, happiness + 15);
        System.out.println(petName + " had fun! Happiness: " + happiness);
    }

    public void healPet() {
        if (isDead()) return;
        health = Math.min(100, health + 20);
        System.out.println(petName + " is recovering! Health: " + health);
    }

    public void simulateDay() {
        if (isDead()) return;

        age++;
        happiness = Math.max(0, happiness - new Random().nextInt(10));
        health = Math.max(0, health - new Random().nextInt(10));

        if (health == 0) {
            stage = "Ghost 👻";
            System.out.println(petName + " has died and become a ghost!");
        } else {
            evolvePet();
        }
    }

    private void evolvePet() {
        if (age < 2) stage = EVOLUTION_STAGES[1];
        else if (age < 4) stage = EVOLUTION_STAGES[2];
        else if (age < 7) stage = EVOLUTION_STAGES[3];
        else if (age < 10) stage = EVOLUTION_STAGES[4];
        else stage = EVOLUTION_STAGES[5];
    }

    public String getPetStatus() {
        return petName + " [" + petId + "] - " + stage + " | Age: " + age +
               " | Happiness: " + happiness + " | Health: " + health;
    }

    public boolean isDead() {
        return stage.equals("Ghost 👻");
    }

    // === Static Utilities ===
    private static String generatePetId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private static String getRandomSpecies() {
        String[] species = {"Dragon", "Fox", "Cat", "Wolf", "Bird"};
        return species[new Random().nextInt(species.length)];
    }

    // === Main simulation ===
    public static void main(String[] args) {
        System.out.println("=== VIRTUAL PET DAYCARE ===");

        VirtualPet p1 = new VirtualPet();                   // egg
        VirtualPet p2 = new VirtualPet("Luna");             // baby
        VirtualPet p3 = new VirtualPet("Shadow", "Dragon"); // child
        VirtualPet p4 = new VirtualPet("Fluffy", "Cat", 5, 80, 90, "Teen");

        VirtualPet[] daycare = {p1, p2, p3, p4};

        for (int day = 1; day <= 5; day++) {
            System.out.println("\n--- Day " + day + " ---");
            for (VirtualPet pet : daycare) {
                pet.simulateDay();
                pet.feedPet();
                pet.playWithPet();
                System.out.println(pet.getPetStatus());
            }
        }
        System.out.println("\nTotal pets created: " + totalPetsCreated);
    }
}
