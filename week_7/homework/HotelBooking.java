package week_7.homework;

public class HotelBooking {
    public void bookRoom(String roomType, int nights) {
        System.out.println("Standard booking: " + roomType + " for " + nights + " nights. Price: " + (nights * 100));
    }
    public void bookRoom(String roomType, int nights, double seasonalMultiplier) {
        System.out.println("Seasonal booking: " + roomType + " for " + nights + " nights.");
        System.out.println("Price with seasonal multiplier: " + (nights * 100 * seasonalMultiplier));
    }
    public void bookRoom(String roomType, int nights, double corporateDiscount, boolean isCorporate) {
        double price = nights * 100;
        if (isCorporate) price = price - (price * corporateDiscount);
        System.out.println("Corporate booking: " + roomType + " for " + nights + " nights.");
        System.out.println("Price after discount: " + price);
    }
    public void bookRoom(String roomType, int nights, String mealPackage) {
        System.out.println("Booking with meal package: " + mealPackage);
        System.out.println("Total price: " + (nights * 120));
    }
    public void bookRoom(String roomType, int nights, int guestCount, double decorationFee) {
        int basePrice = nights * 100;
        double total = basePrice + decorationFee + (guestCount * 20);
        System.out.println("Wedding package booking for " + guestCount + " guests. Total price: " + total);
    }
    public static void main(String[] args) {
        HotelBooking hb = new HotelBooking();
        hb.bookRoom("Deluxe", 3);
        hb.bookRoom("Suite", 5, 1.2);
        hb.bookRoom("Standard", 4, 0.1, true);
        hb.bookRoom("Deluxe", 2, "Breakfast");
        hb.bookRoom("Suite", 3, 100, 50);
    }
}
