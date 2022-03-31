package mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
//import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import dto.AuthorDTO;
import model.Author;


@Mapper(componentModel = "cdi")
public interface AuthorMapper {
	
	AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
	
	@Mapping(target = "book", ignore = true)
	AuthorDTO toDTO(Author author);
	
	List<AuthorDTO> toDTO(List<Author> authors);
	
	@Mapping(target = "id", ignore = true)
	Author toEntity(AuthorDTO authorDTO);
}
