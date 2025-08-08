package libraryManagementSystem;
// Main class

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "libraryData.dat";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = loadLibrary();

        if (library == null) {
            library = new Library();
            // Adding default data only first time
            library.addBook(new Book(1, "Java Basics", "James Gosling"));
            library.addBook(new Book(2, "OOP Concepts", "Bjarne Stroustrup"));
            library.addBook(new Book(3, "Data Structures", "Robert Lafore"));

            library.addUser(new User(101, "Radha"));
            library.addUser(new User(102, "Raja"));
        }

        while (true) {
            System.out.println("\n==== Library Menu ====");
            System.out.println("1. Display Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter Book ID: ");
                    int bId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int uId = sc.nextInt();
                    library.issueBook(bId, uId);
                    saveLibrary(library);
                    break;
                case 3:
                    System.out.print("Enter Book ID: ");
                    int rId = sc.nextInt();
                    library.returnBook(rId);
                    saveLibrary(library);
                    break;
                case 4:
                    saveLibrary(library);
                    System.out.println("Data saved. Exiting system...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Save Library object to file
    private static void saveLibrary(Library library) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(library);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // Load Library object from file
    private static Library loadLibrary() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (Library) ois.readObject();
        } catch (FileNotFoundException e) {
            return null; // First run, no file yet
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
            return null;
        }
    }
}