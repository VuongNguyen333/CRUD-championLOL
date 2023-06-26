package com.example.champions.service;

import com.example.champions.exception.UserNotFoundException;
import com.example.champions.model.Champion;
import com.example.champions.repository.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChampionService {
   private final ChampionRepository championRepository;

   @Autowired
   public ChampionService(ChampionRepository championRepository) {
      this.championRepository = championRepository;
   }

   public List<Champion> getChampion(){
      return championRepository.findAll();
   }

   public Champion findChampionById(Long id){
      return championRepository.findChampionById(id)
             .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
   }
   public Champion addNewChampion (Champion champion){
      Optional<Champion> championOptional = championRepository.findChampionByName(champion.getName());
      if(championOptional.isPresent()) {
         throw new IllegalStateException("champion already exist");
      }
      else {
         return championRepository.save(champion);
      }
   }

   public void updateChampion(Champion champion) {
      championRepository.save(champion);
   }

   public void deleteChampionById(Long id){
      boolean exists = championRepository.existsById(id);
      if(!exists) {
         throw new IllegalStateException("Champion With Id " + id +  "does not exist!");
      } else {
         championRepository.deleteById(id);
      }
   }


}
