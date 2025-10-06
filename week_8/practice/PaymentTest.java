package week_8.practice;
// Problem 3: Interface for Payment Gateway

interface PaymentGateway {
    void pay(double amount);
    void refund(double amount);
}

class CreditCardPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via Credit Card");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded ₹" + amount + " to Credit Card");
    }
}

class UPIPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " via UPI");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded ₹" + amount + " to UPI");
    }
}

public class PaymentTest {
    public static void main(String[] args) {
        PaymentGateway p1 = new CreditCardPayment();
        p1.pay(1500);
        p1.refund(500);

        PaymentGateway p2 = new UPIPayment();
        p2.pay(800);
        p2.refund(200);
    }
}
