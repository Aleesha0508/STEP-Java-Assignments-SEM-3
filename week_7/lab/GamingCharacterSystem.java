package week_7.lab;

public class GamingCharacterSystem {
    public static void main(String[] args) {
        Character[] army = {new Warrior(), new Mage(), new Archer()};
        for (Character c : army) c.attack();
    }
}
abstract class Character {
    abstract void attack();
}
class Warrior extends Character {
    @Override
    void attack() {
        System.out.println("Warrior attacks with sword and high defense!");
    }
}
class Mage extends Character {
    @Override
    void attack() {
        System.out.println("Mage casts powerful spells using mana!");
    }
}
class Archer extends Character {
    @Override
    void attack() {
        System.out.println("Archer shoots long-range arrows!");
    }
}
