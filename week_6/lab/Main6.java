package week_6.lab;

class Box {
    void pack() {
        System.out.println("Box is packed");
    }
    void unpack() {
        System.out.println("Box is unpacked");
    }
}

class GiftBox extends Box {
    @Override
    void pack() {
        super.pack();
        System.out.println("Gift wrap added");
    }
    @Override
    void unpack() {
        super.unpack();
        System.out.println("Gift unwrapped");
    }
}

public class Main6 {
    public static void main(String[] args) {
        GiftBox g = new GiftBox();
        g.pack();
        g.unpack();
    }
}
