package week_3.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Subject {
    private String subjectCode;
    private String subjectName;
    private int credits;
    private String instructor;

    public Subject(String code, String name, int credits, String instructor) {
        this.subjectCode = code; this.subjectName = name; this.credits = credits; this.instructor = instructor;
    }
    public String getSubjectCode() { return subjectCode; }
    public String getSubjectName() { return subjectName; }
    public int getCredits() { return credits; }
}

class StudentG {
    private String studentId;
    private String studentName;
    private String className;
    private String[] subjects;
    private double[][] marks; // marks[studentIndex][subjectIndex] - for simplicity here each Student has marks for subjects length
    private double gpa;

    public static int totalStudents = 0;
    public static String schoolName = "ABC High School";
    public static String[] gradingScale = {"A","B","C","D","F"};
    public static double passPercentage = 40.0;

    public StudentG(String studentId, String studentName, String className, String[] subjects) {
        this.studentId = studentId; this.studentName = studentName; this.className = className;
        this.subjects = subjects;
        this.marks = new double[1][subjects.length];
        totalStudents++;
    }

    public void addMarks(int subjectIndex, double mark) {
        if (subjectIndex >= 0 && subjectIndex < subjects.length) marks[0][subjectIndex] = mark;
    }

    public void calculateGPA() {
        double total = 0;
        for (double m : marks[0]) total += m;
        double avg = total / marks[0].length;
        // simple mapping: GPA out of 10 based on percentage
        this.gpa = (avg / 100.0) * 10.0;
    }

    public void generateReportCard() {
        System.out.println("Report Card for " + studentName + " (" + studentId + ")");
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%s: %.2f%n", subjects[i], marks[0][i]);
        }
        System.out.printf("GPA: %.2f%n", gpa);
    }

    public boolean checkPromotionEligibility() {
        for (double m : marks[0]) if (m < passPercentage) return false;
        return true;
    }

    public double getAverageMarks() {
        double s = 0;
        for (double m : marks[0]) s += m;
        return s / marks[0].length;
    }

    public String getStudentName() { return studentName; }
    public String getStudentId() { return studentId; }
}

public class StudentGradeManagement {
    public static double calculateClassAverage(StudentG[] students) {
        double total = 0;
        for (StudentG s : students) total += s.getAverageMarks();
        return total / students.length;
    }

    public static StudentG[] getTopPerformers(StudentG[] students, int count) {
        Arrays.sort(students, Comparator.comparingDouble(StudentG::getAverageMarks).reversed());
        return Arrays.copyOf(students, Math.min(count, students.length));
    }

    public static void generateSchoolReport(StudentG[] students) {
        System.out.println("School: " + StudentG.schoolName);
        System.out.println("Total Students: " + StudentG.totalStudents);
        System.out.printf("Class Average: %.2f%n", calculateClassAverage(students));
    }

    public static void main(String[] args) {
        String[] subs = {"Math","English","Science"};
        StudentG s1 = new StudentG("S01","Alice","10A", subs);
        StudentG s2 = new StudentG("S02","Bob","10A", subs);
        s1.addMarks(0,95); s1.addMarks(1,88); s1.addMarks(2,90);
        s2.addMarks(0,70); s2.addMarks(1,65); s2.addMarks(2,75);
        s1.calculateGPA(); s2.calculateGPA();
        s1.generateReportCard(); s2.generateReportCard();
        StudentG[] arr = {s1,s2};
        generateSchoolReport(arr);
        StudentG[] top = getTopPerformers(arr,1);
        System.out.println("Top performer: " + top[0].getStudentName());
    }
}
