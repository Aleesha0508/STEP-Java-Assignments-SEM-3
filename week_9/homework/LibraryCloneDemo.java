package week_9.homework;

import java.util.ArrayList;
import java.util.List;

class Book implements Cloneable {
    String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return title;
    }
}

class Library implements Cloneable {
    List<Book> books = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
    }

    // Shallow Clone
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // Deep Clone
    public Library deepClone() throws CloneNotSupportedException {
        Library clonedLib = (Library) super.clone();
        clonedLib.books = new ArrayList<>();
        for (Book b : this.books) {
            clonedLib.books.add((Book) b.clone());
        }
        return clonedLib;
    }

    @Override
    public String toString() {
        return books.toString();
    }
}

public class LibraryCloneDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Library lib1 = new Library();
        lib1.addBook(new Book("Harry Potter"));
        lib1.addBook(new Book("Percy Jackson"));

        Library shallow = (Library) lib1.clone();
        Library deep = lib1.deepClone();

        lib1.books.get(0).title = "Changed Book";

        System.out.println("Original Library: " + lib1);
        System.out.println("Shallow Clone: " + shallow);
        System.out.println("Deep Clone: " + deep);
    }
}
