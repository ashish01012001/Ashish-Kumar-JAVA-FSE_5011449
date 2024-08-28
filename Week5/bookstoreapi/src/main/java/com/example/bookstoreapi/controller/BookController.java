package Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;

import Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.assembler.BookModelAssembler;
import Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.dto.BookDTO;
import Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.mapper.BookMapper;
import Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.metrics.CustomMetrics;
import Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.model.Book;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// @RestController
// @RequestMapping("/books")
// public class BookController {

// private List<Book> books = new ArrayList<>();

// // CREATE: POST /books - Add a new book
// @PostMapping
// @ResponseStatus(HttpStatus.CREATED)
// public BookDTO createBook(@Valid @RequestBody BookDTO bookDTO) {
// Book book = BookMapper.INSTANCE.toEntity(bookDTO);
// books.add(book);
// return BookMapper.INSTANCE.toDTO(book);
// }

// // READ: GET /books - Get all books
// @GetMapping
// public List<BookDTO> getAllBooks() {
// return books.stream()
// .map(BookMapper.INSTANCE::toDTO)
// .collect(Collectors.toList());
// }

// // READ: GET /books/{id} - Get a book by ID
// @GetMapping("/{id}")
// public BookDTO getBookById(@PathVariable Long id) {
// Optional<Book> book = books.stream().filter(b ->
// b.getId().equals(id)).findFirst();
// if (book.isPresent()) {
// return BookMapper.INSTANCE.toDTO(book.get());
// } else {
// throw new BookNotFoundException("Book not found with ID: " + id);
// }
// }

// // UPDATE: PUT /books/{id} - Update a book by ID
// @PutMapping("/{id}")
// public BookDTO updateBook(@PathVariable Long id, @Valid @RequestBody BookDTO
// bookDTO) {
// Optional<Book> existingBook = books.stream().filter(b ->
// b.getId().equals(id)).findFirst();
// if (existingBook.isPresent()) {
// Book book = BookMapper.INSTANCE.toEntity(bookDTO);
// books.remove(existingBook.get());
// books.add(book);
// return BookMapper.INSTANCE.toDTO(book);
// } else {
// throw new BookNotFoundException("Book not found with ID: " + id);
// }
// }

// // DELETE: DELETE /books/{id} - Delete a book by ID
// @DeleteMapping("/{id}")
// @ResponseStatus(HttpStatus.NO_CONTENT)
// public void deleteBook(@PathVariable Long id) {
// Optional<Book> existingBook = books.stream().filter(b ->
// b.getId().equals(id)).findFirst();
// if (existingBook.isPresent()) {
// books.remove(existingBook.get());
// } else {
// throw new BookNotFoundException("Book not found with ID: " + id);
// }
// }
// }

// Updating the controllers to return the hypermedia-driven responses----------------------------------------
// @RestController
// @RequestMapping("/books")
// public class BookController {

//     private final BookModelAssembler assembler;

//     public BookController(BookModelAssembler assembler) {
//         this.assembler = assembler;
//     }

//     @GetMapping("/{id}")
//     public EntityModel<BookDTO> getBookById(@PathVariable Long id) {
//         Book book = findBookById(id);
//         return assembler.toModel(book);
//     }

//     @GetMapping
//     public List<EntityModel<BookDTO>> getAllBooks() {
//         List<Book> books = findAllBooks();
//         return books.stream()
//                 .map(assembler::toModel)
//                 .collect(Collectors.toList());
//     }

//     @PostMapping
//     @ResponseStatus(HttpStatus.CREATED)
//     public EntityModel<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
//         Book book = saveBook(bookDTO);
//         return assembler.toModel(book);
//     }

// }

// Updating the controller to produce and consume JSON and XML--------------
// @RestController
// @RequestMapping("/books")
// public class BookController {

//     // Example: Fetch book by ID with content negotiation
//     @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//     public BookDTO getBookById(@PathVariable Long id) {
//         return findBookById(id); // Replace with actual logic to fetch the book
//     }

//     // Example: Get all books
//     @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//     public List<BookDTO> getAllBooks() {
//         return findAllBooks(); // Replace with actual logic to fetch books
//     }

//     // Example: Create a new book
//     @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
//             MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//     @ResponseStatus(HttpStatus.CREATED)
//     public BookDTO createBook(@RequestBody BookDTO bookDTO) {
//         return saveBook(bookDTO); // Replace with actual logic to save the book
//     }

//     // Additional methods (update, delete) can be added similarly...
// }

// Updating controller to use Custom Metrics------------
@RestController
@RequestMapping("/books")
public class BookController {

    private final CustomMetrics customMetrics;

    public BookController(CustomMetrics customMetrics) {
        this.customMetrics = customMetrics;
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {
        customMetrics.incrementBookAdditions();
        return saveBook(bookDTO); // Replace with actual logic to save the book
    }

    // Other methods will remain the same as above controllers...
}
