package com.perigea.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.perigea.library.TO.AuthorTO;
import com.perigea.library.TO.BookTO;
import com.perigea.library.mapper.AuthorMapper;
import com.perigea.library.mapper.BookMapper;
import com.perigea.library.repository.AuthorRepository;
import com.perigea.library.repository.BookRepository;

@Service
public class LibraryService implements ILibraryService{
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<AuthorTO> getAllAuthor(){
		return AuthorMapper.INSTANCE.toTO(authorRepository.findAll());
	}

	@Override
	public List<AuthorTO> findByName(String name) {
		return AuthorMapper.INSTANCE.toTO(authorRepository.findByName(name));
	}

	@Override
	public List<BookTO> getAllBook() {
			return BookMapper.INSTANCE.toTO(bookRepository.findAll());
	}
	
	@Override
	public String getExternalService() throws Exception {
		RestTemplate rest = new RestTemplate();
		ResponseEntity<String> resp = rest.getForEntity("https://cex.io/api/tickers/EUR", String.class);
		if(resp.getStatusCode().value() == 200) {
			return resp.getBody();
		}else {
			return null;
		}
	}
}