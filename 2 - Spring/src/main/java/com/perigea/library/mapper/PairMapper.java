package com.perigea.library.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.perigea.library.TO.PairTO;
import com.perigea.library.entity.Pair;

@Mapper(componentModel = "spring")
public interface PairMapper {
	
	PairMapper INSTANCE = Mappers.getMapper(PairMapper.class);

	PairTO toTO(Pair pair);
	List<PairTO> toTO(List<Pair> pairs);
	
	Pair toEntity(PairTO pair);
}
