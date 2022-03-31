package com.perigea.library.TO;

import java.util.List;

import com.perigea.library.entity.Book;

public class AuthorTO {
	
	private static final long serialVersionUID = 1L;
    private int id;
	private String name;
	private List<Book> books;
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
