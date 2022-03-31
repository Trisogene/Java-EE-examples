package com.perigea.extractor.service;
	
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perigea.extractor.TO.CovidDataTO;

@Service
public class ExtractorServiceImpl implements ExtractorService {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Override
	public List<CovidDataTO> getCovidData() throws Exception {
		
		//Inizializza tutte le varabili utili
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper objectMapper = new ObjectMapper();
		List<CovidDataTO> covidDataTOs = new ArrayList<>();
		long millis = System.currentTimeMillis(); 
		Date date = new java.util.Date(millis);      
		String dateString = date.toString();

		
		//Prendi i dati dai siti relativi al vaccino covid
		String covidDataResponse = restTemplate.getForEntity(
				"https://www.dati.lombardia.it/resource/xdg8-8qek.json",
				String.class
		).getBody();
		
		String cityDataReponse = restTemplate.getForEntity(
				"https://comuni-ita.herokuapp.com/api/province",
				String.class
		).getBody();
		
		//Lavora i dati interpolandoli
		JsonNode covidJsonNode = objectMapper.readTree(covidDataResponse);
		JsonNode cityJsonNode = objectMapper.readTree(cityDataReponse);
		covidJsonNode.forEach(covidRow -> {
			CovidDataTO covidDataTO = new CovidDataTO();
			covidDataTO.setCodice(covidRow.get("codistat_comune_dom").asInt());
			covidDataTO.setData(dateString);
			covidDataTO.setComune(covidRow.get("comune_dom").asText());
			covidDataTO.setDose1(covidRow.get("tot_dose1").asInt());
			covidDataTO.setDose2(covidRow.get("tot_dose2").asInt());
			covidDataTO.setProvincia(covidRow.get("provincia_dom").asText());
			cityJsonNode.forEach(cityRow -> {
				String covidProvincia = covidRow.get("provincia_dom").toString();
				String cityProvincia = cityRow.get("nome").toString().toUpperCase();
				if(covidProvincia.equals(cityProvincia)) {
					covidDataTO.setSigla(cityRow.get("sigla").asText());
				}
			});
			
		//Manda i dati come TO nella lista che ritorna indietro e come jsonString a kafka
			covidDataTOs.add(covidDataTO);
			String covidDataToJsonString = "";
			try {
				covidDataToJsonString = objectMapper.writeValueAsString(covidDataTO);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			kafkaTemplate.send("covidTopic", covidDataToJsonString);
		});			
		return covidDataTOs;
	}
}
