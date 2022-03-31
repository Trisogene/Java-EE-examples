package com.perigea.library.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.perigea.library.TO.AuthorTO;
import com.perigea.library.TO.BookTO;
import com.perigea.library.entity.Author;
import com.perigea.library.entity.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {
	
	BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

	BookTO toTO(Book book);
	List<BookTO> toTO(List<Book> books);
	
	AuthorTO toTO(Author author);
	
	Book toEntity(BookTO bookTO);
}
