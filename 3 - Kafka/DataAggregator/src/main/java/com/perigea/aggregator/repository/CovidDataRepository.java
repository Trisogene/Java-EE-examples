package com.perigea.aggregator.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.perigea.aggregator.entity.CovidData;

@Repository
public interface CovidDataRepository extends MongoRepository<CovidData,Integer>{
}
