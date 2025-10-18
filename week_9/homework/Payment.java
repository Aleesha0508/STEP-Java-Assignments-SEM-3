package week_9.homework;

interface Discount {
    double apply(double amount);
}

public class Payment {
    public void processTransaction(double amount) {
        // Local Inner Class
        class Validator {
            boolean isValid() {
                return amount > 0;
            }
        }

        Validator validator = new Validator();
        if (validator.isValid()) {
            // Anonymous Inner Class
            Discount discount = new Discount() {
                @Override
                public double apply(double amt) {
                    return amt * 0.9; // 10% discount
                }
            };

            double finalAmount = discount.apply(amount);
            System.out.println("Payment of $" + finalAmount + " processed successfully after discount.");
        } else {
            System.out.println("Invalid payment amount!");
        }
    }

    public static void main(String[] args) {
        Payment p = new Payment();
        p.processTransaction(1000);
        p.processTransaction(-50);
    }
}
