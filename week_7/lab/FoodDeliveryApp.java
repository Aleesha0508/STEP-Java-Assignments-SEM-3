package week_7.lab;

public class FoodDeliveryApp {
    public void deliveryCharge(int distance) {
        System.out.println("Basic delivery charge for distance " + distance + ": " + (distance * 5));
    }
    public void deliveryCharge(int distance, int priorityFee) {
        System.out.println("Premium delivery charge for distance " + distance + " with priority fee " + priorityFee + ": " + ((distance * 5) + priorityFee));
    }
    public void deliveryCharge(int distance, int numberOfOrders, double discountRate) {
        double total = (distance * 5) * numberOfOrders;
        double discount = total * discountRate;
        System.out.println("Group delivery charge for " + numberOfOrders + " orders over distance " + distance + " after discount: " + (total - discount));
    }
    public void deliveryCharge(int distance, double discountPercent, double freeDeliveryThreshold, double orderAmount) {
        if (orderAmount >= freeDeliveryThreshold) {
            System.out.println("Festival special: Free delivery for order amount " + orderAmount);
        } else {
            double charge = distance * 5 * (1 - discountPercent);
            System.out.println("Festival special delivery charge after " + (discountPercent * 100) + "% discount: " + charge);
        }
    }
    public static void main(String[] args) {
        FoodDeliveryApp app = new FoodDeliveryApp();
        app.deliveryCharge(10);
        app.deliveryCharge(10, 15);
        app.deliveryCharge(10, 3, 0.10);
        app.deliveryCharge(10, 0.2, 100, 120);
        app.deliveryCharge(10, 0.2, 100, 80);
    }
}

