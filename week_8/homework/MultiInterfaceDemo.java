package week_8.homework;

// Topic 6: Multiple Interfaces with Same Method Name

interface Printer {
    void connect();
}

interface Scanner {
    void connect();
}

class AllInOneMachine implements Printer, Scanner {
    @Override
    public void connect() {
        System.out.println("All-In-One Machine connected successfully.");
    }
}

public class MultiInterfaceDemo {
    public static void main(String[] args) {
        Printer p = new AllInOneMachine();
        p.connect();

        Scanner s = new AllInOneMachine();
        s.connect();

        AllInOneMachine aio = new AllInOneMachine();
        aio.connect();
    }
}
