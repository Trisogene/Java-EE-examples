package com.perigea.library.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.perigea.library.TO.AuthorTO;
import com.perigea.library.entity.Author;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

	AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
	
	AuthorTO toTO(Author author);
	List<AuthorTO> toTO(List<Author> authors);
	
	Author toEntity(AuthorTO authorTO);
}
