package week_4.lab;

abstract class MagicalStructure {
    protected String structureName;
    protected int magicPower;
    protected String location;
    protected boolean isActive;

    // Constructor chaining
    public MagicalStructure(String name) {
        this(name, 50, "Unknown", true);
    }

    public MagicalStructure(String name, int magicPower) {
        this(name, magicPower, "Unknown", true);
    }

    public MagicalStructure(String name, int magicPower, String location, boolean isActive) {
        this.structureName = name;
        this.magicPower = magicPower;
        this.location = location;
        this.isActive = isActive;
    }

    public abstract void castMagicSpell();
}

// === Derived Classes ===
class WizardTower extends MagicalStructure {
    private int spellCapacity;
    private String[] knownSpells;

    public WizardTower(String name) {
        super(name);
        this.spellCapacity = 5;
        this.knownSpells = new String[]{"Fireball"};
    }

    public WizardTower(String name, int capacity, String[] spells) {
        super(name, 100);
        this.spellCapacity = capacity;
        this.knownSpells = spells;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " casts a spell from its tower!");
    }
}

class EnchantedCastle extends MagicalStructure {
    private int defenseRating;
    private boolean hasDrawbridge;

    public EnchantedCastle(String name) {
        super(name, 80);
        this.defenseRating = 50;
        this.hasDrawbridge = true;
    }

    public EnchantedCastle(String name, int defense, boolean drawbridge) {
        super(name, 120);
        this.defenseRating = defense;
        this.hasDrawbridge = drawbridge;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " channels protective magic!");
    }
}

class MysticLibrary extends MagicalStructure {
    private int bookCount;
    private String ancientLanguage;

    public MysticLibrary(String name) {
        super(name, 70);
        this.bookCount = 100;
        this.ancientLanguage = "Old Runes";
    }

    public MysticLibrary(String name, int books, String lang) {
        super(name, 90);
        this.bookCount = books;
        this.ancientLanguage = lang;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " reveals hidden knowledge!");
    }
}

class DragonLair extends MagicalStructure {
    private String dragonType;
    private int treasureValue;

    public DragonLair(String name, String type) {
        super(name, 150);
        this.dragonType = type;
        this.treasureValue = 1000;
    }

    @Override
    public void castMagicSpell() {
        System.out.println(structureName + " unleashes dragon fire!");
    }
}

// === Kingdom Manager ===
class KingdomManager {
    public static boolean canStructuresInteract(MagicalStructure s1, MagicalStructure s2) {
        if (s1 instanceof WizardTower && s2 instanceof MysticLibrary) return true;
        if (s1 instanceof EnchantedCastle && s2 instanceof DragonLair) return true;
        return false;
    }

    public static String performMagicBattle(MagicalStructure attacker, MagicalStructure defender) {
        if (attacker.magicPower > defender.magicPower) {
            return attacker.structureName + " defeats " + defender.structureName;
        } else {
            return defender.structureName + " withstands " + attacker.structureName;
        }
    }

    public static int calculateKingdomMagicPower(MagicalStructure[] structures) {
        int total = 0;
        for (MagicalStructure s : structures) total += s.magicPower;
        return total;
    }

    public static void main(String[] args) {
        System.out.println("=== MEDIEVAL KINGDOM ===");

        WizardTower tower = new WizardTower("Arcane Spire");
        EnchantedCastle castle = new EnchantedCastle("Crystal Keep", 200, true);
        MysticLibrary library = new MysticLibrary("Grand Archives");
        DragonLair lair = new DragonLair("Inferno Cavern", "Red Dragon");

        MagicalStructure[] structures = {tower, castle, library, lair};

        for (MagicalStructure s : structures) {
            s.castMagicSpell();
        }

        System.out.println("\nInteractions:");
        System.out.println("Tower + Library: " + canStructuresInteract(tower, library));
        System.out.println("Castle + Lair: " + canStructuresInteract(castle, lair));

        System.out.println("\nBattle: " + performMagicBattle(tower, lair));
        System.out.println("Total Kingdom Magic Power: " + calculateKingdomMagicPower(structures));
    }
}
