package week_3.homework;

class PersonalAccount {
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;

    private static int totalAccounts = 0;
    private static String bankName = "DefaultBank";

    public PersonalAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = initialBalance;
        this.totalIncome = initialBalance > 0 ? initialBalance : 0;
        this.totalExpenses = 0;
        totalAccounts++;
    }

    public void addIncome(double amount, String description) {
        try {
            if (amount <= 0) throw new IllegalArgumentException("Income must be positive");
            currentBalance += amount;
            totalIncome += amount;
            System.out.println("Added income: " + amount + " (" + description + ")");
        } catch (Exception e) {
            System.out.println("Error adding income: " + e.getMessage());
        }
    }

    public void addExpense(double amount, String description) {
        try {
            if (amount <= 0) throw new IllegalArgumentException("Expense must be positive");
            if (amount > currentBalance) throw new IllegalArgumentException("Insufficient balance");
            currentBalance -= amount;
            totalExpenses += amount;
            System.out.println("Added expense: " + amount + " (" + description + ")");
        } catch (Exception e) {
            System.out.println("Error adding expense: " + e.getMessage());
        }
    }

    public double calculateSavings() {
        return totalIncome - totalExpenses;
    }

    public void displayAccountSummary() {
        System.out.println("----- Account Summary -----");
        System.out.println("Bank: " + bankName);
        System.out.println("Holder: " + accountHolderName);
        System.out.println("Account#: " + accountNumber);
        System.out.printf("Balance: %.2f, Total Income: %.2f, Total Expenses: %.2f%n",
                currentBalance, totalIncome, totalExpenses);
        System.out.printf("Savings: %.2f%n", calculateSavings());
        System.out.println("---------------------------");
    }

    public static void setBankName(String name) {
        if (name != null && !name.trim().isEmpty()) bankName = name;
    }

    public static int getTotalAccounts() { return totalAccounts; }

    public static String generateAccountNumber() {
        return "PA" + String.format("%04d", totalAccounts + 1);
    }
}

public class PersonalFinanceManager {
    public static void main(String[] args) {
        PersonalAccount.setBankName("MyCommunityBank");
        PersonalAccount a1 = new PersonalAccount("Alice", 1000);
        PersonalAccount a2 = new PersonalAccount("Bob", 500);
        PersonalAccount a3 = new PersonalAccount("Charlie", 0);

        a1.addIncome(2000, "Salary");
        a1.addExpense(150, "Groceries");
        a2.addIncome(300, "Freelance");
        a2.addExpense(50, "Transport");
        a3.addIncome(100, "Gift");
        a3.addExpense(30, "Snack");

        a1.displayAccountSummary();
        a2.displayAccountSummary();
        a3.displayAccountSummary();

        System.out.println("Total accounts created: " + PersonalAccount.getTotalAccounts());
        // Demonstrate bankName shared
        PersonalAccount.setBankName("NeighborhoodBank");
        a1.displayAccountSummary();
        a2.displayAccountSummary();
    }
}
