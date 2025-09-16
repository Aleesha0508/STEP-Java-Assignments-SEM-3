package week_4.homework;

class FoodOrder {
    String customerName, foodItem;
    int quantity;
    double price;
    static final double fixedRate = 100.0;

    FoodOrder() {
        this("Unknown", "Unknown", 0, 0.0);
    }

    FoodOrder(String foodItem) {
        this("Unknown", foodItem, 1, fixedRate);
    }

    FoodOrder(String foodItem, int quantity) {
        this("Unknown", foodItem, quantity, quantity * fixedRate);
    }

    FoodOrder(String customerName, String foodItem, int quantity, double price) {
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.price = price;
    }

    void printBill() {
        System.out.println("Customer: " + customerName + ", Item: " + foodItem + ", Quantity: " + quantity + ", Total: " + price);
    }

    public static void main(String[] args) {
        FoodOrder f1 = new FoodOrder();
        FoodOrder f2 = new FoodOrder("Burger");
        FoodOrder f3 = new FoodOrder("Pizza", 3);
        FoodOrder f4 = new FoodOrder("Alice", "Pasta", 2, 300);
        f1.printBill();
        f2.printBill();
        f3.printBill();
        f4.printBill();
    }
}
