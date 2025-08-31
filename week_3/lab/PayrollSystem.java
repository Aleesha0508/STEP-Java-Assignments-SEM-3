package week_3.lab;

class Employee {
    private String empId, empName, department, empType;
    private double baseSalary;
    private static int totalEmployees = 0;
    private static int counter = 0;

    // Constructor for Full-time
    public Employee(String empName, String dept, double baseSalary) {
        this.empId = generateEmpId();
        this.empName = empName;
        this.department = dept;
        this.baseSalary = baseSalary;
        this.empType = "Full-Time";
        totalEmployees++;
    }

    // Constructor for Part-time
    public Employee(String empName, double hourlyRate, int hours) {
        this.empId = generateEmpId();
        this.empName = empName;
        this.department = "Part-Time";
        this.baseSalary = hourlyRate * hours;
        this.empType = "Part-Time";
        totalEmployees++;
    }

    // Constructor for Contract
    public Employee(String empName, double fixedAmount) {
        this.empId = generateEmpId();
        this.empName = empName;
        this.department = "Contract";
        this.baseSalary = fixedAmount;
        this.empType = "Contract";
        totalEmployees++;
    }

    private static String generateEmpId() {
        counter++;
        return "E" + String.format("%03d", counter);
    }

    public double calculateSalary() {
        return baseSalary;
    }

    public double calculateTax() {
        if (empType.equals("Full-Time")) return baseSalary * 0.2;
        if (empType.equals("Part-Time")) return baseSalary * 0.1;
        return baseSalary * 0.05;
    }

    public void generatePaySlip() {
        System.out.println(empName + " (" + empType + ") Salary: " + calculateSalary() + ", Tax: " + calculateTax());
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", "IT", 50000);
        Employee e2 = new Employee("Bob", 200, 80);
        Employee e3 = new Employee("Charlie", 40000);

        e1.generatePaySlip();
        e2.generatePaySlip();
        e3.generatePaySlip();
    }
}
