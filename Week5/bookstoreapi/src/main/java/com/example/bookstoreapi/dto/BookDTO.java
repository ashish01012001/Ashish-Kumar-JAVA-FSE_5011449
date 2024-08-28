package Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BookDTO {

    private Long id;

    @NotBlank(message = "Title is mandatory")
    @Size(min = 2, message = "Title should have at least 2 characters")
    private String title;

    @NotBlank(message = "Author is mandatory")
    private String author;

    @NotNull(message = "Price is mandatory")
    @Min(value = 0, message = "Price should be positive")
    private Double price;

    @NotBlank(message = "ISBN is mandatory")
    private String isbn;
}