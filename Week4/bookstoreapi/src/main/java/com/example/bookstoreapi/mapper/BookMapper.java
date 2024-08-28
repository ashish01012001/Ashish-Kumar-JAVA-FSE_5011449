package Week4.bookstoreapi.src.main.java.com.example.bookstoreapi.mapper;

import Week4.bookstoreapi.src.main.java.com.example.bookstoreapi.dto.BookDTO;
import Week4.bookstoreapi.src.main.java.com.example.bookstoreapi.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDTO toDTO(Book book);

    Book toEntity(BookDTO bookDTO);
}
