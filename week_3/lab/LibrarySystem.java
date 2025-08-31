package week_3.lab;

class Book {
    private String bookId, title, author;
    private boolean isAvailable;
    private static int totalBooks = 0, availableBooks = 0;
    private static int counter = 0;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.bookId = generateBookId();
        this.isAvailable = true;
        totalBooks++;
        availableBooks++;
    }

    private static String generateBookId() {
        counter++;
        return "B" + String.format("%03d", counter);
    }

    public void issueBook() {
        if (isAvailable) {
            isAvailable = false;
            availableBooks--;
            System.out.println(title + " issued.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            availableBooks++;
            System.out.println(title + " returned.");
        }
    }

    public void displayBookInfo() {
        System.out.println("ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable);
    }
}

class Member {
    private String memberId, memberName;
    private String[] booksIssued = new String[5];
    private int bookCount = 0;
    private static int counter = 0;

    public Member(String memberName) {
        this.memberName = memberName;
        this.memberId = generateMemberId();
    }

    private static String generateMemberId() {
        counter++;
        return "M" + String.format("%03d", counter);
    }

    public void borrowBook(Book book) {
        if (bookCount < 5) {
            book.issueBook();
            booksIssued[bookCount++] = book.toString();
        } else {
            System.out.println(memberName + " cannot borrow more books.");
        }
    }

    public void returnBook(Book book) {
        book.returnBook();
        bookCount--;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book b1 = new Book("Java", "James Gosling");
        Book b2 = new Book("Python", "Guido van Rossum");

        Member m1 = new Member("Alice");
        m1.borrowBook(b1);
        m1.borrowBook(b2);

        b1.displayBookInfo();
        b2.displayBookInfo();
    }
}
