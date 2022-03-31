package com.perigea.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perigea.library.entity.Pair;

@Repository
public interface PairRepository extends JpaRepository<Pair,Long> {
}
