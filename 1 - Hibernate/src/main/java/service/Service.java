package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import dao.AuthorDao;
import dao.BookDao;
import dto.AuthorDTO;
import dto.BookDTO;
import mapper.AuthorMapper;
import mapper.BookMapper;
import model.Author;
import model.Book;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class Service {
	
	@Inject
	BookDao bookDao;
	
	@Inject
	AuthorDao authorDao;
	

	public BookDTO getBook(int id) {
		BookDTO bookDTO = BookMapper.INSTANCE.toDTO(bookDao.get(id));
		return bookDTO;
	}
	
	
	public List<BookDTO> getAllBook() {
		List<BookDTO> books = BookMapper.INSTANCE.toDTO(bookDao.getAll());
		return 	books;
	}
	
	public List<BookDTO> getAllBookAuthor(int id) {
		List<BookDTO> books = BookMapper.INSTANCE.toDTO(bookDao.getAllBookByAuthor(id));
		return books;
	}
	
	public Book addBook(BookDTO bookDTO) {
		
		Book book = BookMapper.INSTANCE.toEntity(bookDTO);
		Author author = authorDao.get(book.getAuthor().getId());
		author.setBooks(null);
		book.setAuthor(author);
		bookDao.insert(book);
		
		return book;
	}

	public AuthorDTO getAuthor(int id) {
		return AuthorMapper.INSTANCE.toDTO(authorDao.get(id));
	}
	
	public List<AuthorDTO> getAllAuthor() {
		return 	AuthorMapper.INSTANCE.toDTO(authorDao.getAll());
	}
	
	public Author addAuthor(AuthorDTO authorDTO) {
		Author author = AuthorMapper.INSTANCE.toEntity(authorDTO);
		authorDao.insert(author);
		return author;
	}

	public AuthorDTO updateAuthor(AuthorDTO authorDTO) {
		Author author = authorDao.getAuthorAndBook(authorDTO.getId());
		author.setName(authorDTO.getName());
		authorDao.update(author);
		return authorDTO;
	}
	
}
