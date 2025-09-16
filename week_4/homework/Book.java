package week_4.homework;

class Book {
    String title, author, isbn;
    boolean isAvailable;

    Book() {
        this("", "", "", true);
    }

    Book(String title, String author) {
        this(title, author, "", true);
    }

    Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    void borrowBook() {
        if (isAvailable) isAvailable = false;
        else System.out.println("Book not available");
    }

    void returnBook() {
        isAvailable = true;
    }

    void displayBookInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Available: " + isAvailable);
    }

    public static void main(String[] args) {
        Book bk1 = new Book();
        Book bk2 = new Book("1984", "Orwell");
        Book bk3 = new Book("Brave New World", "Huxley", "12345", true);
        bk2.borrowBook();
        bk3.borrowBook();
        bk2.displayBookInfo();
        bk3.displayBookInfo();
        bk2.returnBook();
        bk2.displayBookInfo();
    }
}
