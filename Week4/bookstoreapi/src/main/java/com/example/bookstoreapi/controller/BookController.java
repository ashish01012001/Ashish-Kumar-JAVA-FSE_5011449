package Week4.bookstoreapi.src.main.java.com.example.bookstoreapi.controller;

import Week4.bookstoreapi.src.main.java.com.example.bookstoreapi.exception.BookNotFoundException;
import Week4.bookstoreapi.src.main.java.com.example.bookstoreapi.model.Book;
import Week4.bookstoreapi.src.main.java.com.example.bookstoreapi.dto.BookDTO;
import Week4.bookstoreapi.src.main.java.com.example.bookstoreapi.mapper.BookMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// @RestController
// @RequestMapping("/books")
// public class BookController {
// private List<Book> books = new ArrayList<>();

// // GET /books - Retrieve all books
// @GetMapping
// public List<Book> getAllBooks() {
// return books;
// }

// // GET /books/{id} - Retrieve a book by ID
// @GetMapping("/{id}")
// public ResponseEntity<Book> getBookById(@PathVariable Long id) {
// Optional<Book> book = books.stream().filter(b ->
// b.getId().equals(id)).findFirst();
// if (book.isPresent()) {
// return ResponseEntity.ok(book.get());
// } else {
// return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
// }
// }

// // GET /books/search - Retrieve books by title and/or author
// @GetMapping("/search")
// public List<Book> searchBooks(
// @RequestParam(required = false) String title,
// @RequestParam(required = false) String author) {

// return books.stream()
// .filter(book -> (title == null || book.getTitle().equalsIgnoreCase(title)) &&
// (author == null || book.getAuthor().equalsIgnoreCase(author)))
// .collect(Collectors.toList());
// }

// // POST /books - Create a new book
// @PostMapping
// public ResponseEntity<Book> createBook(@RequestBody Book book) {
// books.add(book);
// return ResponseEntity.status(HttpStatus.CREATED).body(book);
// }

// // PUT /books/{id} - Update a book by ID
// @PutMapping("/{id}")
// public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody
// Book updatedBook) {
// Optional<Book> bookOptional = books.stream().filter(b ->
// b.getId().equals(id)).findFirst();
// if (bookOptional.isPresent()) {
// Book book = bookOptional.get();
// book.setTitle(updatedBook.getTitle());
// book.setAuthor(updatedBook.getAuthor());
// book.setPrice(updatedBook.getPrice());
// book.setIsbn(updatedBook.getIsbn());
// return ResponseEntity.ok(book);
// } else {
// return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
// }
// }

// // DELETE /books/{id} - Delete a book by ID
// @DeleteMapping("/{id}")
// public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
// boolean removed = books.removeIf(book -> book.getId().equals(id));
// if (removed) {
// return ResponseEntity.noContent().build();
// } else {
// return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
// }
// }
// }

// Customizing HTTP Response Status with
// @ResponseStatus---------------------------------------------------
// @RestController
// @RequestMapping("/books")
// public class BookController {

// private List<Book> books = new ArrayList<>();

// // GET /books/{id} - Retrieve a book by ID
// @GetMapping("/{id}")
// public Book getBookById(@PathVariable Long id) {
// Optional<Book> book = books.stream().filter(b ->
// b.getId().equals(id)).findFirst();
// if (book.isPresent()) {
// return book.get();
// } else {
// throw new BookNotFoundException("Book not found with ID: " + id);
// }
// }

// // POST /books - Create a new book
// @PostMapping
// @ResponseStatus(HttpStatus.CREATED) // Sets 201 Created status
// public Book createBook(@RequestBody Book book){books.add(book);return book;}

// // PUT /books/{id} - Update a book by ID
// @PutMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) // Sets 204 No Content status
// public void updateBook(@PathVariable Long id,@RequestBody Book updatedBook){Optional<Book>bookOptional=books.stream().filter(b->b.getId().equals(id)).findFirst();if(bookOptional.isPresent()){Book book=bookOptional.get();book.setTitle(updatedBook.getTitle());book.setAuthor(updatedBook.getAuthor());book.setPrice(updatedBook.getPrice());book.setIsbn(updatedBook.getIsbn());}else{throw new BookNotFoundException("Book not found with ID: "+id);}}

// // DELETE /books/{id} - Delete a book by ID
// @DeleteMapping("/{id}")
// @ResponseStatus(HttpStatus.NO_CONTENT) // Sets 204 No Content status
// public void deleteBook(@PathVariable Long id) {
// boolean removed = books.removeIf(book -> book.getId().equals(id));
// if (!removed) {
// throw new BookNotFoundException("Book not found with ID: " + id);
// }
// }

// @ResponseStatus(HttpStatus.NOT_FOUND)
// @ExceptionHandler(BookNotFoundException.class)
// public String handleNotFound(BookNotFoundException ex) {
// return ex.getMessage();
// }
// }

// Controllers using mappers--------------------------------------

public class BookController {

    private List<Book> books = new ArrayList<>();

    // GET /books - Retrieve all books as DTOs
    @GetMapping
    public List<BookDTO> getAllBooks() {
        return books.stream()
                .map(BookMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    // POST /books - Create a new book from a DTO
    @PostMapping
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.toEntity(bookDTO);
        books.add(book);
        return BookMapper.INSTANCE.toDTO(book);
    }

    // Other methods remain the same...
}