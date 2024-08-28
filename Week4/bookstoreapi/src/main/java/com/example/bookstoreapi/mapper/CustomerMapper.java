package Week4.bookstoreapi.src.main.java.com.example.bookstoreapi.mapper;

import Week4.bookstoreapi.src.main.java.com.example.bookstoreapi.dto.CustomerDTO;
import Week4.bookstoreapi.src.main.java.com.example.bookstoreapi.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO toDTO(Customer customer);

    Customer toEntity(CustomerDTO customerDTO);
}
