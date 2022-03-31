package servlet;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.AuthorDao;
import dto.AuthorDTO;
import dto.BookDTO;
import model.Author;
import model.Book;
import service.Service;

@Stateless
@TransactionAttribute(TransactionAttributeType.NEVER)
@Path("controller")
public class RestController {


	
	@Inject
	private Service service;
	
	//Author : basic function
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAuthor/{authorId}")
	public AuthorDTO getAuthor(@PathParam("authorId") int id) {
		return service.getAuthor(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllAuthor/")
	public List<AuthorDTO> getAllAuthor() {
		return service.getAllAuthor();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addAuthor/")
	public Author addAuthor(AuthorDTO authorDTO) {
		return service.addAuthor(authorDTO);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateAuthor/")
	public AuthorDTO updateAuthor(AuthorDTO authorDTO) {
		return service.updateAuthor(authorDTO);
	}
	
	//Book : basic function
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getBook/{bookId}")
	public BookDTO getBook(@PathParam("bookId") int id) {
		return service.getBook(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllBook/")
	public List<BookDTO> getAllBook() {
		return service.getAllBook();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllBookByAuthor/{authorId}")
	public List<BookDTO> getAllBookByAuthor(@PathParam("authorId") int id) {
		return service.getAllBookAuthor(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addBook/")
	public Book addBook(BookDTO bookDTO) {
		return service.addBook(bookDTO);
	}
}
