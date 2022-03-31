package com.perigea.library.service;

import java.util.List;

import com.perigea.library.TO.AuthorTO;
import com.perigea.library.TO.BookTO;

public interface ILibraryService {
	
	public List<AuthorTO> getAllAuthor();

	public List<AuthorTO> findByName(String name);
	
	public List<BookTO> getAllBook();
	
	public String getExternalService() throws Exception ;
}
