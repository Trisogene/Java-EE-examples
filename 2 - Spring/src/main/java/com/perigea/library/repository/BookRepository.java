package com.perigea.library.repository;


import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.perigea.library.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> { 
	
	public List<Book> findByName(String name);
	
//	@Query(value="SELECT * FROM book",nativeQuery = true)
//	public List<Book> findCustomAll();
}