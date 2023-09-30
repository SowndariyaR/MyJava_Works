//Name:Sowndariya R
//Enrollment No:EBEON0823825928
//Batch No:2023-10226
//Tiny project topic:LibraryManagementSystem
//Library Management System user can add books, borrow books, return books, and display the list of available books
//Keywords:package,import,class,private,public,arraylist,int,String,this,boolean,void,if,for while,scanner,
package tinyproject;
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void borrow() {
        available = false;
    }

    public void returnBook() {
        available = true;
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Library Books:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Available: " + (book.isAvailable() ? "Yes" : "No"));
            System.out.println();
        }
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                return book;
            }
        }
        return null;
    }
}

public class Sowndariya_LibraryManagementSystem {
public static void main(String[] args) {
    Library library = new Library();
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("Library Management System");
        System.out.println("1. Add Book");
        System.out.println("2. Borrow Book");
        System.out.println("3. Return Book");
        System.out.println("4. Display Books");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter book title: ");
                String title = scanner.nextLine();
                System.out.print("Enter book author: ");
                String author = scanner.nextLine();
                library.addBook(title, author);
                break;
            case 2:
                System.out.print("Enter book title to borrow: ");
                String borrowTitle = scanner.nextLine();
                Book borrowBook = library.findBook(borrowTitle);
                if (borrowBook != null) {
                    borrowBook.borrow();
                    System.out.println("Book '" + borrowTitle + "' borrowed successfully.");
                } else {
                    System.out.println("Book not available or not found.");
                }
                break;
            case 3:
                System.out.print("Enter book title to return: ");
                String returnTitle = scanner.nextLine();
                Book returnBook = library.findBook(returnTitle);
                if (returnBook != null) {
                    returnBook.returnBook();
                    System.out.println("Book '" + returnTitle + "' returned successfully.");
                } else {
                    System.out.println("Book not found or already returned.");
                }
                break;
            case 4:
                library.displayBooks();
                break;
            case 5:
                System.out.println("Exiting Library Management System. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
}


