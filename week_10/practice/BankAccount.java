package week_10.practice;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private int pin;

    public BankAccount(String accountNumber, double balance, int pin) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
    }

    public boolean validatePin(int enteredPin) {
        return enteredPin == pin;
    }

    public void debit(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn. Remaining balance: ₹" + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

