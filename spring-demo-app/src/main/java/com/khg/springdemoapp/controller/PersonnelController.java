package com.khg.springdemoapp.controller;

import com.khg.springdemoapp.model.entity.Personnel;
import com.khg.springdemoapp.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("personnel")
public class PersonnelController {
    @Autowired
    PersonnelService personnelService;

    @GetMapping("all-personnel")
    public List<Personnel> getAllPersonnel() {
        return personnelService.getAllPersonnel();
    }

    @GetMapping("all-personnel-city")
    public List<Personnel> getAllPersonnelForACity(@RequestParam String city) {
        return personnelService.getAllPersonnelForACity(city);
    }

    @GetMapping("all-personnel-rank")
    public List<Personnel> getAllPersonnelForRank(@RequestParam String rank) {
        return personnelService.getAllPersonnelForRank(rank);
    }

    @GetMapping("search-personnel")
    public List<Personnel> getAllPersonnelForRank(@RequestParam String name, @RequestParam String surname) {
        return personnelService.searchWithNameAndSurname(name, surname);
    }
}
