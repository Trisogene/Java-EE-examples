package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Author;

public class AuthorDao implements Dao<Author> {

	@PersistenceContext(unitName = "persistenceUnit1")
	private EntityManager em;
	
	@Override
	public Author get(int id) {
		return em.find(Author.class, id);
	}
	
	public Author getAuthorAndBook(int id) {
		return (Author) em.createNativeQuery("SELECT * FROM author LEFT JOIN book ON author.id = book.author WHERE author.id =:authorId",Author.class)
				.setParameter("authorId", id).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> getAll() {
		List<Author> authors = em.createNativeQuery("SELECT * FROM author",Author.class).getResultList();
		return authors;
	}

	public void insert(Author author) {
		em.persist(author);
	}
	
	public void update(Author author) {
		em.merge(author);
	}

	@Override
	public void delete(Author t) {
		em.remove(t);
	}
		
}
