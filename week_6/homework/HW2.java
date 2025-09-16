package week_6.homework;

class Tool {
    private String privateField = "Private Data";
    protected String protectedField = "Protected Data";
    public String publicField = "Public Data";

    public String getPrivateField() {
        return privateField;
    }
}

class Hammer extends Tool {
    void showAccess() {
        // System.out.println(privateField); ❌ not accessible
        System.out.println("Private via getter: " + getPrivateField());
        System.out.println("Protected: " + protectedField);
        System.out.println("Public: " + publicField);
    }
}

public class HW2 {
    public static void main(String[] args) {
        Hammer h = new Hammer();
        h.showAccess();
    }
}
