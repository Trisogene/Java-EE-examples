package dto;

import java.util.List;

public class AuthorDTO {
	
	private Integer id;
	private String name;
	private List<BookDTO> book;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<BookDTO> getBook() {
		return book;
	}
	public void setBook(List<BookDTO> book) {
		this.book = book;
	}
}
