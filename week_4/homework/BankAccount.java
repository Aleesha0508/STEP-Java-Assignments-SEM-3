package week_4.homework;

import java.util.Random;

class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    BankAccount() {
        this("Unknown", new Random().nextInt(100000), 0.0);
    }

    BankAccount(String accountHolder) {
        this(accountHolder, new Random().nextInt(100000), 0.0);
    }

    BankAccount(String accountHolder, double balance) {
        this(accountHolder, new Random().nextInt(100000), balance);
    }

    BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        if (balance >= amount) balance -= amount;
        else System.out.println("Insufficient balance");
    }

    void displayAccount() {
        System.out.println("Holder: " + accountHolder + ", Acc#: " + accountNumber + ", Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        BankAccount b2 = new BankAccount("Alice");
        BankAccount b3 = new BankAccount("Bob", 1000);
        b2.deposit(500);
        b3.withdraw(200);
        b1.displayAccount();
        b2.displayAccount();
        b3.displayAccount();
    }
}
