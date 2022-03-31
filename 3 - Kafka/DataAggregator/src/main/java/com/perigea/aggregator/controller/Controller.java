package com.perigea.aggregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perigea.aggregator.entity.CovidData;
import com.perigea.aggregator.service.AggregatorService;

@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	AggregatorService aggregatorService;

	@GetMapping("/getData")
	public String getData() {
	    return aggregatorService.findAll().toString();
	}
	
	@PostMapping("/saveData")
	public CovidData saveData(CovidData covidData) {
	    return aggregatorService.save(covidData);
	}
	
	@GetMapping("/removeAllData")
	public void removeAllData() {
	    aggregatorService.removeAll();
	}
	
	@KafkaListener(topics = "covidTopic", groupId = "covidGroup")
	public void listenCovidGroup(String message) throws Exception {
	    aggregatorService.convertAndSave(message);
	}
	
	//API RICHIESTE
	
	/*
	 * Restituire il numero totale della regione lombardia dei vaccinati con singola dose
	 */
	@GetMapping("/getLombardyVaxNumber")
	public int getLombardyVaxNumber() {
	    return aggregatorService.getLombardyVaxNumber();
	}
}
