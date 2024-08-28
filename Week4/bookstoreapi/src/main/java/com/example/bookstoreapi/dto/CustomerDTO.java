package Week4.bookstoreapi.src.main.java.com.example.bookstoreapi.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
    private String address;
}
