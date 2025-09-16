package week_6.homework;

class Game {
    String name;

    Game(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Game: " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Game)) return false;
        Game g = (Game) obj;
        return name.equals(g.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

class CardGame extends Game {
    int cards;

    CardGame(String name, int cards) {
        super(name);
        this.cards = cards;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cards: " + cards;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof CardGame)) return false;
        CardGame cg = (CardGame) obj;
        return cards == cg.cards;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + cards;
    }
}

public class HW3 {
    public static void main(String[] args) {
        Game g1 = new Game("Chess");
        CardGame c1 = new CardGame("Poker", 52);
        CardGame c2 = new CardGame("Poker", 52);
        System.out.println(g1);
        System.out.println(c1);
        System.out.println("c1 equals c2? " + c1.equals(c2));
    }
}
