package week_3.practice;

class Subject {
    private String subjectCode;
    private String subjectName;
    private int maxMarks;
    private int passMarks;

    public Subject(String code, String name, int max, int pass) {
        this.subjectCode = code;
        this.subjectName = name;
        this.maxMarks = max;
        this.passMarks = pass;
    }

    public int getPassMarks() { return passMarks; }
    public String getSubjectName() { return subjectName; }
}

class Student {
    private String studentId;
    private String studentName;
    private int grade;
    double[] marks;
    private double totalMarks;
    private double percentage;

    public Student(String id, String name, double[] marks) {
        this.studentId = id;
        this.studentName = name;
        this.marks = marks;
    }

    public void calculateTotal() {
        totalMarks = 0;
        for (double m : marks) totalMarks += m;
        percentage = totalMarks / marks.length;
    }

    public void displayResult() {
        System.out.println(studentId + " " + studentName + " Total: " + totalMarks + " Percentage: " + percentage);
    }

    public boolean isPass(Subject[] subjects) {
        for (int i = 0; i < subjects.length; i++) if (marks[i] < subjects[i].getPassMarks()) return false;
        return true;
    }
}

class Teacher {
    private String teacherId;
    private String teacherName;
    private String subject;
    private int studentsHandled;
    private static int totalTeachers = 0;

    public Teacher(String id, String name, String subject) {
        this.teacherId = id;
        this.teacherName = name;
        this.subject = subject;
        totalTeachers++;
    }

    public void assignGrades(Student student, Subject subject, double mark, int index) { student.marks[index] = mark; }
    public void displayTeacherInfo() { System.out.println(teacherId + " " + teacherName + " Subject: " + subject); }
    public static int getTotalTeachers() { return totalTeachers; }
}

public class SchoolManagement {
    public static void main(String[] args) {
        Subject[] subjects = { new Subject("S01", "Math", 100, 40), new Subject("S02", "English", 100, 40) };
        Student[] students = { new Student("ST01", "Alice", new double[2]), new Student("ST02", "Bob", new double[2]) };
        Teacher t1 = new Teacher("T01", "Mr. Smith", "Math");
        Teacher t2 = new Teacher("T02", "Ms. Jane", "English");

        t1.assignGrades(students[0], subjects[0], 90, 0);
        t2.assignGrades(students[0], subjects[1], 85, 1);
        t1.assignGrades(students[1], subjects[0], 35, 0);
        t2.assignGrades(students[1], subjects[1], 45, 1);

        for (Student s : students) { s.calculateTotal(); s.displayResult(); }
        t1.displayTeacherInfo(); t2.displayTeacherInfo();
        System.out.println("Total Teachers: " + Teacher.getTotalTeachers());
    }
}
