package com.perigea.library.TO;

import com.perigea.library.entity.Author;

public class BookTO {
	
	private Integer id;
	private String name;
	private Author author;
	
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
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
}
