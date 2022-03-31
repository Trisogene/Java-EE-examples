package com.perigea.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perigea.library.TO.AuthorTO;
import com.perigea.library.TO.BookTO;
import com.perigea.library.entity.Pair;
import com.perigea.library.service.ILibraryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api")
public class LibraryController {
	
	@Autowired
	ILibraryService libraryService;

	@GetMapping(value="/author/getAll")
	public ResponseEntity<List<AuthorTO>> getAllAuthor(){
		return ResponseEntity.ok().body(libraryService.getAllAuthor());
	}
	
	@GetMapping(value="/author/findByName/")
	public ResponseEntity<List<AuthorTO>> findByName(@RequestParam(defaultValue = "") String name){
		return ResponseEntity.ok().body(libraryService.findByName(name));
	}
	
	@GetMapping(value="/book/getAll")
	public ResponseEntity<List<BookTO>> getAllBook(){
		return ResponseEntity.ok().body(libraryService.getAllBook());
	}
	
	@GetMapping(value="/external")
	public String getExternalService() throws Exception{
		
		log.info("-----------------------");
		log.info("Chiamo servizio esterno");
		log.info("-----------------------");
		String response = libraryService.getExternalService();
		log.info("risposta : {}", response);
		log.info("-----------------------");
		
		//Logging data 
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(response);
		JsonNode data = jsonNode.get("data");
		
		List<Pair> pairs = new ArrayList<Pair>();
		for (JsonNode row : data) {

			Pair pair = new Pair();
			pair.setPair(row.get("pair").asText());
			pair.setCurrentPrice(Float.valueOf(row.get("last").asText()).floatValue());
			pairs.add(pair);
			log.info(pair.toString());
		}
		log.info("-----------------------");
		
		return response;
	}

}
