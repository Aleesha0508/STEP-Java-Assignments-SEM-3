package week_3.homework;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

class BookL {
    private String bookId;
    private String title;
    private String author;
    private String isbn;
    private String category;
    private boolean isIssued;
    private LocalDate issueDate;
    private LocalDate dueDate;

    public BookL(String bookId, String title, String author, String isbn, String category) {
        this.bookId = bookId; this.title = title; this.author = author; this.isbn = isbn; this.category = category;
        this.isIssued = false;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public boolean isIssued() { return isIssued; }
    public LocalDate getDueDate() { return dueDate; }

    public void issue(LocalDate issueDate, int days) {
        this.isIssued = true;
        this.issueDate = issueDate;
        this.dueDate = issueDate.plusDays(days);
    }

    public double returnBookAndCalculateFine(LocalDate returnDate, double finePerDay) {
        this.isIssued = false;
        if (returnDate.isAfter(dueDate)) {
            long overdue = ChronoUnit.DAYS.between(dueDate, returnDate);
            return overdue * finePerDay;
        }
        return 0.0;
    }

    public void renew(int extraDays) {
        if (dueDate != null) dueDate = dueDate.plusDays(extraDays);
    }
}

class MemberL {
    private String memberId;
    private String memberName;
    private String memberType; // Student/Faculty/General
    private List<BookL> booksIssued = new ArrayList<>();
    private double totalFines = 0.0;
    private LocalDate membershipDate;

    public MemberL(String id, String name, String type) {
        this.memberId = id; this.memberName = name; this.memberType = type; this.membershipDate = LocalDate.now();
    }

    public boolean canIssueMore() {
        int max = 5;
        if (memberType.equalsIgnoreCase("Student")) max = 3;
        else if (memberType.equalsIgnoreCase("Faculty")) max = 10;
        return booksIssued.size() < max;
    }

    public void issueBook(BookL book, int days) {
        if (book == null || book.isIssued()) return;
        if (!canIssueMore()) return;
        book.issue(LocalDate.now(), days);
        booksIssued.add(book);
    }

    public double returnBook(BookL book, double finePerDay) {
        if (book == null) return 0.0;
        LocalDate ret = LocalDate.now();
        double fine = book.returnBookAndCalculateFine(ret, finePerDay);
        booksIssued.remove(book);
        totalFines += fine;
        return fine;
    }

    public void renewBook(BookL book, int extraDays) {
        if (booksIssued.contains(book)) book.renew(extraDays);
    }
}

public class LibraryWithFines {
    private static int totalBooks = 0;
    private static int totalMembers = 0;
    private static String libraryName = "CityLibrary";
    private static double finePerDay = 10.0;
    private static int maxBooksAllowed = 5;

    public static void main(String[] args) {
        BookL b1 = new BookL("B001","Java Basics","A","ISBN001","Programming");
        BookL b2 = new BookL("B002","OOP Concepts","B","ISBN002","Programming");
        totalBooks = 2;

        MemberL m1 = new MemberL("M001","Alice","Student");
        MemberL m2 = new MemberL("M002","Prof. Bob","Faculty");
        totalMembers = 2;

        m1.issueBook(b1, 7); // 7 days due
        // simulate return after days by calling returnBook which uses LocalDate.now() -> for demo we won't wait
        // but we can simulate by invoking book.returnBookAndCalculateFine with custom date (not exposed) — keeping simple

        // Display basic report
        System.out.println("Library: " + libraryName);
        System.out.println("Total Books: " + totalBooks + " Total Members: " + totalMembers);
        System.out.println("Fine per day: " + finePerDay);
    }
}
