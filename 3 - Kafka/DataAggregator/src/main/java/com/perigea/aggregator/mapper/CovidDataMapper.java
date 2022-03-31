package com.perigea.aggregator.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.perigea.aggregator.TO.CovidDataTO;
import com.perigea.aggregator.entity.CovidData;

@Mapper(componentModel = "spring")
public interface CovidDataMapper {

	CovidDataMapper INSTANCE = Mappers.getMapper(CovidDataMapper.class);
	
	CovidDataTO toTO(CovidData covidData);
	CovidData toEntity(CovidDataTO covidDataTO);
	List<CovidDataTO> toTO(List<CovidData> covidDatas);
}
