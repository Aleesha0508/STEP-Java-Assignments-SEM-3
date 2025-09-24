package week_7.lab;

public class UniversityLibrarySystem {
    public static void main(String[] args) {
        LibraryUser[] users = {new Student(), new Faculty(), new Guest()};
        for (LibraryUser u : users) {
            u.enterLibrary();
            u.displayPrivileges();
        }
    }
}
class LibraryUser {
    void enterLibrary() {
        System.out.println("User entering the library.");
    }
    void displayPrivileges() {
        System.out.println("General library access.");
    }
}
class Student extends LibraryUser {
    @Override
    void displayPrivileges() {
        System.out.println("Students can borrow books and access computers.");
    }
}
class Faculty extends LibraryUser {
    @Override
    void displayPrivileges() {
        System.out.println("Faculty can reserve books and access research databases.");
    }
}
class Guest extends LibraryUser {
    @Override
    void displayPrivileges() {
        System.out.println("Guests can only browse books.");
    }
}

