package com.perigea.extractor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perigea.extractor.TO.CovidDataTO;
import com.perigea.extractor.service.ExtractorService;

@RestController
@RequestMapping("/api")
public class ExtractorController {
	
	@Autowired
	ExtractorService covidService; 
	
	@GetMapping("/getCovidData")
	public List<CovidDataTO> getCovidData() throws Exception {
		return covidService.getCovidData();
	}
}
