package com.perigea.extractor.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.perigea.extractor.TO.CovidDataTO;
import com.perigea.extractor.entity.CovidData;

@Mapper(componentModel = "spring")
public interface CovidDataMapper {

	CovidDataMapper INSTANCE = Mappers.getMapper(CovidDataMapper.class);
	
	CovidDataTO toTO(CovidData wallet);
	CovidData toEntity(CovidDataTO wallet);
}
