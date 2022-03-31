package com.perigea.library.repository;


import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perigea.library.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> { 
	
	public List<Author> findByName(String name);
}