package com.perigea.aggregator.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RegioneServiceImpl implements RegionService {

	@Override
	public boolean inLombardia(String province) {
		
		List<String> lombardyProvince = Arrays.asList(
				"BS","BG","CO","CR","LC","LO","MN","MI","MB","PV","SO","VA"
				);
		
		if(lombardyProvince.contains(province)) {
			return true;
		}else {
			return false;
		}
	}

}
