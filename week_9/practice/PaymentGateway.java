package week_9.practice;

class Payment {
    public void pay() {
        System.out.println("Generic payment");
    }
}

class CreditCardPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Payment via Credit Card");
    }
}

class WalletPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Payment via Wallet");
    }
}

public class PaymentGateway {
    public static void main(String[] args) {
        Payment[] payments = { new CreditCardPayment(), new WalletPayment(), new Payment() };

        for (Payment p : payments) {
            System.out.println("Processing: " + p.getClass().getSimpleName());
            p.pay();
        }
    }
}
