package week_4.homework;

class MovieTicket {
    String movieName, theatreName;
    int seatNumber;
    double price;

    MovieTicket() {
        this("Unknown", "Unknown", 0, 0.0);
    }

    MovieTicket(String movieName) {
        this(movieName, "Unknown", 0, 200.0);
    }

    MovieTicket(String movieName, int seatNumber) {
        this(movieName, "PVR", seatNumber, 200.0);
    }

    MovieTicket(String movieName, String theatreName, int seatNumber, double price) {
        this.movieName = movieName;
        this.theatreName = theatreName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    void printTicket() {
        System.out.println("Movie: " + movieName + ", Theatre: " + theatreName + ", Seat: " + seatNumber + ", Price: " + price);
    }

    public static void main(String[] args) {
        MovieTicket t1 = new MovieTicket();
        MovieTicket t2 = new MovieTicket("Inception");
        MovieTicket t3 = new MovieTicket("Interstellar", 5);
        MovieTicket t4 = new MovieTicket("Dune", "IMAX", 12, 500);
        t1.printTicket();
        t2.printTicket();
        t3.printTicket();
        t4.printTicket();
    }
}
