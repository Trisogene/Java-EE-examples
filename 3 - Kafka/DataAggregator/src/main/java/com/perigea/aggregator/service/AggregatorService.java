package com.perigea.aggregator.service;

import java.util.List;

import com.perigea.aggregator.entity.CovidData;

public interface AggregatorService {

	public List<CovidData> findAll();

	public CovidData save(CovidData covidData);

	public void convertAndSave(String message) throws Exception;

	public int getLombardyVaxNumber();

	public void removeAll();
}
