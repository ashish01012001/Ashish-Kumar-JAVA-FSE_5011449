package Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.dto.BookDTO;
import Week5.bookstoreapi.src.main.java.com.example.bookstoreapi.model.Book;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO toDTO(Book book);

    Book toEntity(BookDTO bookDTO);
}
