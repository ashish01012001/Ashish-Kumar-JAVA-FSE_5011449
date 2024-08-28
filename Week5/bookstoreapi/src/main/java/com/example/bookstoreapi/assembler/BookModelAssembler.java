package Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.assembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.controller.BookController;
import Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.dto.BookDTO;
import Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.model.Book;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BookModelAssembler extends RepresentationModelAssemblerSupport<Book, EntityModel<BookDTO>> {

    public BookModelAssembler() {
        super(BookController.class, EntityModel.class);
    }

    @Override
    public EntityModel<BookDTO> toModel(Book book) {
        BookDTO bookDTO = new BookDTO();
        // Map book entity to bookDTO here...

        return EntityModel.of(bookDTO,
                linkTo(methodOn(BookController.class).getBookById(book.getId())).withSelfRel(),
                linkTo(methodOn(BookController.class).getAllBooks()).withRel("books"));
    }
}
