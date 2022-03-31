package com.perigea.aggregator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.perigea.aggregator.entity.CovidData;
import com.perigea.aggregator.repository.CovidDataRepository;

@Service
public class AggregatorServiceImpl implements AggregatorService{
	
	@Autowired
	CovidDataRepository covidDataRepository;
	
	@Autowired
	RegionService regionService;
	
	@Override
	public List<CovidData> findAll() {
		return covidDataRepository.findAll();
	}
	@Override
	public CovidData save(CovidData covidData) {
		return covidDataRepository.save(covidData);
	}
	@Override
	public void convertAndSave(String message) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		CovidData covidData = objectMapper.readValue(message, CovidData.class);
		covidDataRepository.save(covidData);
	}
	@Override
	public int getLombardyVaxNumber() {
		List<CovidData> covidDatas = covidDataRepository.findAll();
		
		int secondDoseTotal = 0;
		for(CovidData covidData : covidDatas) {
			if(regionService.inLombardia(covidData.getSigla())) {
				System.out.println(covidData.getComune() + " : " + covidData.getDose2());
				secondDoseTotal += covidData.getDose2();
			}
		}
		return secondDoseTotal;
	}
	@Override
	public void removeAll() {
		covidDataRepository.deleteAll();
	}
	
}
