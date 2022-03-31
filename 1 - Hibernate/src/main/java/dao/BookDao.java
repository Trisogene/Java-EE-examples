package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Author;
import model.Book;

public class BookDao implements Dao<Book> {

	@PersistenceContext(unitName = "persistenceUnit1")
	private EntityManager em;
	
	//@Override
	public Book get(int id) {
		return em.find(Book.class, id);
	}

//	@Override
	@SuppressWarnings("unchecked")
	public List<Book> getAll() {
		return em.createNativeQuery("SELECT * FROM book", Book.class).getResultList();
	}
	
	@Override
	public void insert(Book t) {
		em.persist(t);
	}

//	@Override
	public void delete(Book t) {
		em.remove(t);
	}

	@SuppressWarnings("unchecked")
	public List<Book> getAllBookByAuthor(int id) {
		return em.createNativeQuery("SELECT * FROM book WHERE author = :authorId", Book.class).setParameter("authorId", id).getResultList();
	}

}
