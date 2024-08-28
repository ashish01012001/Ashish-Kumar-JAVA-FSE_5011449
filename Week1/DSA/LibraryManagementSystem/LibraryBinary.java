package Week1.DSA.LibraryManagementSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LibraryBinary {
    private List<Book> books;

    public LibraryBinary() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        Collections.sort(books, Comparator.comparing(Book::getTitle));
    }

    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);
            int comparison = midBook.getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return midBook;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LibraryBinary libraryBinary = new LibraryBinary();
        libraryBinary.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        libraryBinary.addBook(new Book(2, "To Kill a Mockingbird", "Harper Lee"));
        libraryBinary.addBook(new Book(3, "1984", "George Orwell"));

        // Binary Search
        System.out.println("Binary Search:");
        Book book = libraryBinary.binarySearchByTitle("1984");
        System.out.println(book != null ? book : "Book not found");
    }
}
