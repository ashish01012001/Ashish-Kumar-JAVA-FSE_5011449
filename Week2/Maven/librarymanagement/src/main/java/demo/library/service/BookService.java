package demo.library.service;

import demo.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

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
