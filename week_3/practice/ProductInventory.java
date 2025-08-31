package week_3.practice;

class Product {
    private String productId;
    private String productName;
    private double price;
    private int quantity;
    private String supplierName;
    private String category;
    private static int totalProducts = 0;
    private static double totalInventoryValue = 0;

    public Product(String name, double price, int qty, String supplier, String category) {
        this.productId = generateProductId();
        this.productName = name;
        this.price = price;
        this.quantity = qty;
        this.supplierName = supplier;
        this.category = category;
        totalProducts++;
        totalInventoryValue += price * qty;
    }

    public void addStock(int qty) { quantity += qty; totalInventoryValue += price * qty; }
    public void reduceStock(int qty) { if (qty <= quantity) { quantity -= qty; totalInventoryValue -= price * qty; } }
    public double calculateProductValue() { return price * quantity; }
    public void updatePrice(double newPrice) { totalInventoryValue -= price * quantity; price = newPrice; totalInventoryValue += price * quantity; }
    public void displayProductInfo() { System.out.println(productId + " " + productName + " " + category + " Price: " + price + " Qty: " + quantity); }

    public static String generateProductId() { return "P" + String.format("%03d", totalProducts + 1); }
    public static double getTotalInventoryValue() { return totalInventoryValue; }
}

public class ProductInventory {
    public static void main(String[] args) {
        Product[] products = new Product[3];
        products[0] = new Product("Laptop", 50000, 5, "Dell", "Electronics");
        products[1] = new Product("Mouse", 500, 20, "Logitech", "Electronics");
        products[2] = new Product("Chair", 2000, 10, "Ikea", "Furniture");

        products[0].addStock(2);
        products[1].reduceStock(5);
        products[2].updatePrice(1800);

        for (Product p : products) p.displayProductInfo();
        System.out.println("Total Inventory Value: " + Product.getTotalInventoryValue());
    }
}
