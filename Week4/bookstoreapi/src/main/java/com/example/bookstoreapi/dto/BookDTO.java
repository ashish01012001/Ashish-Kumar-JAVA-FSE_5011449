package Week4.bookstoreapi.src.main.java.com.example.bookstoreapi.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.Data;

// @Data
// public class BookDTO {
// private Long id;
// private String title;
// private String author;
// private Double price;
// private String isbn;
// }

// Serialization of the price field-----------
@Data
public class BookDTO {
    private Long id;
    private String title;
    private String author;

    private Double price;

    @JsonGetter("cost")
    public Double getPrice() {
        return price;
    }

    @JsonSetter("cost")
    public void setPrice(Double price) {
        this.price = price;
    }

    private String isbn;
}