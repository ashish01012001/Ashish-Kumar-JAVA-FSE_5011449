package Week2.Maven.Exercise4onwards.librarymanagement.src.main.java.com.library.service;

import Week2.Maven.Exercise4onwards.librarymanagement.src.main.java.com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;

    // Constructor for constructor injection
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Setter method for setter injection
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void printService() {
        System.out.println("BookService is working!");
        if (bookRepository != null) {
            bookRepository.printRepository();
        }
    }
}