package week_3.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String productId;
    private String productName;
    private double price;
    private String category;
    private int stockQuantity;

    public static int totalProducts = 0;
    public static String[] categories = {"Electronics", "Books", "Clothing", "Home", "Toys"};

    public Product(String id, String name, double price, String category, int stock) {
        this.productId = id;
        this.productName = name;
        this.price = price;
        this.category = category;
        this.stockQuantity = stock;
        totalProducts++;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getStockQuantity() { return stockQuantity; }

    public boolean reduceStock(int qty) {
        if (qty <= 0 || qty > stockQuantity) return false;
        stockQuantity -= qty;
        return true;
    }

    public void addStock(int qty) {
        if (qty > 0) stockQuantity += qty;
    }

    public void displayProduct() {
        System.out.printf("%s | %s | %.2f | %s | Stock: %d%n", productId, productName, price, category, stockQuantity);
    }

    public static Product findProductById(Product[] products, String productId) {
        if (products == null || productId == null) return null;
        for (Product p : products) if (p != null && p.getProductId().equalsIgnoreCase(productId)) return p;
        return null;
    }

    public static List<Product> getProductsByCategory(Product[] products, String category) {
        List<Product> out = new ArrayList<>();
        if (products == null) return out;
        for (Product p : products) if (p != null && p.getCategory().equalsIgnoreCase(category)) out.add(p);
        return out;
    }
}

class ShoppingCart {
    private String cartId;
    private String customerName;
    private List<Product> products = new ArrayList<>();
    private List<Integer> quantities = new ArrayList<>();
    private double cartTotal = 0.0;

    public ShoppingCart(String cartId, String customerName) {
        this.cartId = cartId;
        this.customerName = customerName;
    }

    public boolean addProduct(Product product, int quantity) {
        if (product == null || quantity <= 0) return false;
        if (product.getStockQuantity() < quantity) return false;
        product.reduceStock(quantity);
        products.add(product);
        quantities.add(quantity);
        cartTotal += product.getPrice() * quantity;
        return true;
    }

    public boolean removeProduct(String productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equalsIgnoreCase(productId)) {
                Product p = products.remove(i);
                int q = quantities.remove(i);
                p.addStock(q);
                cartTotal -= p.getPrice() * q;
                return true;
            }
        }
        return false;
    }

    public double calculateTotal() { return cartTotal; }

    public void displayCart() {
        System.out.println("Cart: " + cartId + " Customer: " + customerName);
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%s x%d -> %.2f%n", products.get(i).getProductName(), quantities.get(i),
                    products.get(i).getPrice() * quantities.get(i));
        }
        System.out.printf("Total: %.2f%n", cartTotal);
    }

    public void checkout() {
        System.out.println("Checking out cart " + cartId + " Total payable: " + cartTotal);
        products.clear();
        quantities.clear();
        cartTotal = 0.0;
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Product[] catalog = new Product[] {
                new Product("P001","Laptop",50000,"Electronics",5),
                new Product("P002","Headphones",1500,"Electronics",10),
                new Product("P003","Java Book",800,"Books",12),
                new Product("P004","T-Shirt",400,"Clothing",20),
                new Product("P005","Coffee Maker",2500,"Home",3),
                new Product("P006","Toy Car",300,"Toys",15),
                new Product("P007","Notebook",50,"Books",50),
                new Product("P008","Jacket",2500,"Clothing",8),
                new Product("P009","Smartphone",20000,"Electronics",4),
                new Product("P010","Mug",120,"Home",25)
        };

        ShoppingCart cart = new ShoppingCart("CART001", "Alice");
        cart.addProduct(Product.findProductById(catalog, "P001"), 1);
        cart.addProduct(Product.findProductById(catalog, "P003"), 2);
        cart.displayCart();
        cart.removeProduct("P003");
        cart.displayCart();

        // Example browse by category
        System.out.println("Electronics:");
        for (Product p : Product.getProductsByCategory(catalog, "Electronics")) p.displayProduct();

        cart.checkout();
    }
}
