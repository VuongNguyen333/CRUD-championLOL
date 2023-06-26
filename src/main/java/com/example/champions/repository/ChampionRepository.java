package com.example.champions.repository;

import com.example.champions.model.Champion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChampionRepository extends JpaRepository<Champion, Long > {
   Optional<Champion> findChampionByName(String name);
   Optional<Champion> findChampionById(Long id);
}
