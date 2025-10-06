package week_8.homework;

// Topic 5: Abstraction in Real-world Example

abstract class BankAccount {
    protected double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public abstract void calculateInterest();

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: ₹" + amount);
        System.out.println("New Balance: ₹" + balance);
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    public void calculateInterest() {
        double interest = balance * 0.04;
        System.out.println("Savings Account Interest: ₹" + interest);
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(double balance) {
        super(balance);
    }

    @Override
    public void calculateInterest() {
        double interest = balance * 0.02;
        System.out.println("Current Account Interest: ₹" + interest);
    }
}

public class BankDemo {
    public static void main(String[] args) {
        BankAccount sa = new SavingsAccount(10000);
        sa.deposit(2000);
        sa.calculateInterest();

        BankAccount ca = new CurrentAccount(15000);
        ca.deposit(3000);
        ca.calculateInterest();
    }
}
