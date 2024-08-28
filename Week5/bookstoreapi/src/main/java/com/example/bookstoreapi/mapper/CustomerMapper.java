package Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.dto.CustomerDTO;
import Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.model.Customer;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO toDTO(Customer customer);

    Customer toEntity(CustomerDTO customerDTO);
}
