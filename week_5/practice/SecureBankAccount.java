package week_5.practice;

public class SecureBankAccount {
    private final String accountNumber;
    private double balance;
    private int pin;
    private boolean isLocked;
    private int failedAttempts;

    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final double MIN_BALANCE = 0.0;

    public SecureBankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance >= MIN_BALANCE ? initialBalance : MIN_BALANCE;
        this.pin = 0;
        this.isLocked = false;
        this.failedAttempts = 0;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return isLocked ? -1 : balance; }
    public boolean isAccountLocked() { return isLocked; }

    public void setPin(int oldPin, int newPin) {
        if (this.pin == oldPin) this.pin = newPin;
    }

    public boolean validatePin(int enteredPin) {
        if (isLocked) return false;
        if (enteredPin == pin) { resetFailedAttempts(); return true; }
        incrementFailedAttempts();
        return false;
    }

    public void unlockAccount(int correctPin) {
        if (pin == correctPin) { isLocked = false; resetFailedAttempts(); }
    }

    public void deposit(double amount, int enteredPin) {
        if (validatePin(enteredPin) && amount > 0) balance += amount;
    }

    public void withdraw(double amount, int enteredPin) {
        if (validatePin(enteredPin) && amount <= balance) balance -= amount;
    }

    public void transfer(SecureBankAccount target, double amount, int enteredPin) {
        if (validatePin(enteredPin) && amount <= balance) {
            balance -= amount;
            target.balance += amount;
        }
    }

    private void lockAccount() { isLocked = true; }
    private void resetFailedAttempts() { failedAttempts = 0; }
    private void incrementFailedAttempts() {
        failedAttempts++;
        if (failedAttempts >= MAX_FAILED_ATTEMPTS) lockAccount();
    }

    public static void main(String[] args) {
        SecureBankAccount a1 = new SecureBankAccount("ACC001", 500);
        SecureBankAccount a2 = new SecureBankAccount("ACC002", 1000);

        a1.setPin(0, 1234);
        a2.setPin(0, 5678);

        a1.deposit(200, 1234);
        a1.withdraw(100, 1234);
        a1.transfer(a2, 300, 1234);

        System.out.println("A1 balance: " + a1.getBalance());
        System.out.println("A2 balance: " + a2.getBalance());

        // Wrong pin attempts
        a1.withdraw(50, 9999);
        a1.withdraw(50, 9999);
        a1.withdraw(50, 9999); // Locks account
        System.out.println("A1 locked? " + a1.isAccountLocked());
    }
}
