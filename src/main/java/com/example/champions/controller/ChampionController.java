package com.example.champions.controller;

import com.example.champions.model.Champion;
import com.example.champions.service.ChampionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/champion")
public class ChampionController {
   private final ChampionService championService;

   @Autowired
   public ChampionController(ChampionService championService) {
      this.championService = championService;
   }

   @GetMapping
   public List<Champion> getChampion(){
      return championService.getChampion();
   }

   @GetMapping("/find/{id}")
   public Champion findChampionById(Long id){
      return championService.findChampionById(id);
   }

   @PostMapping("add")
   public void addChampion(@RequestBody Champion champion){
      championService.addNewChampion(champion);
   }

   @PutMapping(path = "/update/{id}")
   public void updateChampion(@RequestBody Champion champion){
      championService.updateChampion(champion);
   }

   @DeleteMapping(path = "/delete/{id}")
   public void deleteChampionById(@PathVariable("id") Long id) {
      championService.deleteChampionById(id);
   }
}
