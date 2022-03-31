package mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import dto.AuthorDTO;
import dto.BookDTO;
import model.Author;
import model.Book;

@Mapper(componentModel = "cdi")
public interface BookMapper {

	BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
	
	@Mappings({
		@Mapping(target = "authorName", source="author.name"),
		@Mapping(target = "author", ignore=true)
	})
	BookDTO toDTO(Book book);

	AuthorDTO toDTO(Author author);

	List<BookDTO> toDTO(List<Book> books);

	@Mapping(target = "id", ignore = true)
	Book toEntity(BookDTO bookDTO);
}