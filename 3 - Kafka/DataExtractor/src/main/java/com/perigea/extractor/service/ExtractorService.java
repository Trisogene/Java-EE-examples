package com.perigea.extractor.service;

import java.util.List;

import com.perigea.extractor.TO.CovidDataTO;

public interface ExtractorService {
	public List<CovidDataTO> getCovidData() throws Exception;
}
