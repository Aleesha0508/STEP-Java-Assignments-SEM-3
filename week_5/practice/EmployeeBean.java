package week_5.practice;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class EmployeeBean implements Serializable {
    private String employeeId;
    private String firstName;
    private String lastName;
    private double salary;
    private String department;
    private Date hireDate;
    private boolean isActive;

    public EmployeeBean() {}
    public EmployeeBean(String employeeId, String firstName, String lastName,
                        double salary, String department, Date hireDate, boolean isActive) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
        this.hireDate = hireDate;
        this.isActive = isActive;
    }

    public String getEmployeeId() { return employeeId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public Date getHireDate() { return hireDate; }
    public boolean isActive() { return isActive; }

    public void setEmployeeId(String id) { this.employeeId = id; }
    public void setFirstName(String name) { this.firstName = name; }
    public void setLastName(String name) { this.lastName = name; }
    public void setSalary(double salary) { if (salary >= 0) this.salary = salary; }
    public void setDepartment(String dept) { this.department = dept; }
    public void setHireDate(Date d) { this.hireDate = d; }
    public void setActive(boolean active) { this.isActive = active; }

    public String getFullName() { return firstName + " " + lastName; }
    public String getFormattedSalary() {
        return String.format("$%.2f", salary);
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return employeeId + " " + getFullName() + " " + getFormattedSalary() +
               " Dept: " + department + " Hire: " + sdf.format(hireDate) +
               " Active: " + isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeBean)) return false;
        EmployeeBean e = (EmployeeBean) o;
        return Objects.equals(employeeId, e.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId);
    }

    public static void main(String[] args) {
        EmployeeBean emp1 = new EmployeeBean("E001", "Alice", "Smith", 60000, "IT", new Date(), true);
        EmployeeBean emp2 = new EmployeeBean();
        emp2.setEmployeeId("E002");
        emp2.setFirstName("Bob");
        emp2.setLastName("Jones");
        emp2.setSalary(55000);
        emp2.setDepartment("HR");
        emp2.setHireDate(new Date());
        emp2.setActive(true);

        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp1.getFullName());
        System.out.println(emp2.getFormattedSalary());
    }
}
