package week_3.homework;

import java.util.ArrayList;
import java.util.List;

abstract class EmployeeBase {
    protected String empId;
    protected String empName;
    protected String department;
    protected String designation;
    protected double baseSalary;
    protected String joinDate;
    protected boolean[] attendance; // 30 days

    public static int totalEmployees = 0;
    public static String companyName = "TechCorp";
    public static double totalSalaryExpense = 0.0;
    public static int workingDaysPerMonth = 30;

    public EmployeeBase(String id, String name, String dept, String desig, double salary, String joinDate) {
        this.empId = id; this.empName = name; this.department = dept; this.designation = desig;
        this.baseSalary = salary; this.joinDate = joinDate; this.attendance = new boolean[30];
        totalEmployees++;
    }

    public void markAttendance(int day, boolean present) {
        if (day >= 1 && day <= 30) attendance[day-1] = present;
    }

    public abstract double calculateSalary();
    public abstract double calculateBonus();
    public String getEmpName() { return empName; }
}

class FullTimeEmployee extends EmployeeBase {
    public FullTimeEmployee(String id,String name,double salary) { super(id,name,"General","Full-Time",salary,"2025-01-01"); }
    public double calculateSalary() {
        int present = 0; for (boolean b : attendance) if (b) present++;
        double pay = (baseSalary / workingDaysPerMonth) * present;
        totalSalaryExpense += pay;
        return pay;
    }
    public double calculateBonus() { return baseSalary * 0.10; }
}

class PartTimeEmployee extends EmployeeBase {
    private double hourlyRate;
    public PartTimeEmployee(String id,String name,double hourlyRate) { super(id,name,"General","Part-Time",0,"2025-01-01"); this.hourlyRate = hourlyRate; }
    public double calculateSalary() {
        int present = 0; for (boolean b : attendance) if (b) present++;
        double pay = present * 8 * hourlyRate;
        totalSalaryExpense += pay;
        return pay;
    }
    public double calculateBonus() { return 0; }
}

public class EmployeePayrollAttendance {
    public static double calculateCompanyPayroll(EmployeeBase[] employees) {
        double sum = 0;
        for (EmployeeBase e : employees) sum += e.calculateSalary() + e.calculateBonus();
        return sum;
    }

    public static void main(String[] args) {
        FullTimeEmployee ft = new FullTimeEmployee("E001","Alice",50000);
        PartTimeEmployee pt = new PartTimeEmployee("E002","Bob",200);
        ft.markAttendance(1,true); ft.markAttendance(2,true); ft.markAttendance(3,true);
        pt.markAttendance(1,true); pt.markAttendance(2,true);

        EmployeeBase[] emps = {ft, pt};
        double payroll = calculateCompanyPayroll(emps);
        System.out.println("Company payroll total: " + payroll);
    }
}
