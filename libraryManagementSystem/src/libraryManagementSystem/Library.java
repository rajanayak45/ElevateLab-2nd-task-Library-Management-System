package libraryManagementSystem;
// Library class

import java.io.Serializable;
import java.util.ArrayList;

class Library implements Serializable {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void displayBooks() {
        System.out.println("\nBooks in Library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        if (user == null) {
            System.out.println("User not found!");
            return;
        }
        if (book.isIssued()) {
            System.out.println("Book is already issued!");
        } else {
            book.setIssued(true);
            System.out.println("Book issued to " + user.getName());
        }
    }

    public void returnBook(int bookId) {
        Book book = findBook(bookId);
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        if (!book.isIssued()) {
            System.out.println("Book was not issued.");
        } else {
            book.setIssued(false);
            System.out.println("Book returned successfully.");
        }
    }

    private Book findBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    private User findUser(int id) {
        for (User u : users) {
            if (u.getUserId() == id) return u;
        }
        return null;
    }
}