package com.khg.springdemoapp.controller;

import com.khg.springdemoapp.model.dao.PersonnelDao;
import com.khg.springdemoapp.model.entity.Personnel;
import com.khg.springdemoapp.service.PersonnelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personnel")
public class PersonnelController {
    private final
    PersonnelService personnelService;

    public PersonnelController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    @GetMapping("all-personnel")
    public List<Personnel> getAllPersonnel() {
        return personnelService.getAllPersonnel();
    }

    @GetMapping("all-personnel-city")
    public List<Personnel> getAllPersonnelForACity(@RequestParam String city) {
        return personnelService.getAllPersonnelForACity(city);
    }

    @GetMapping("all-personnel-rank")
    public List<Personnel> getAllPersonnelForRank(@RequestParam String rutbe) {
        return personnelService.getAllPersonnelForRank(rutbe);
    }

    @GetMapping("search-personnel")
    public List<Personnel> getAllPersonnelForRank(@RequestParam String name, @RequestParam String surname) {
        return personnelService.searchWithNameAndSurname(name, surname);
    }

    @PostMapping(value = "/add-personnel", consumes = "application/json", produces = "application/json")
    public void addPersonnel(@RequestBody PersonnelDao personnel) {
        personnelService.addPersonnel(personnel);
    }

    @PostMapping(value = "/update-personnel", consumes = "application/json", produces = "application/json")
    public void updatePersonnel(@RequestBody PersonnelDao personnel) {
        personnelService.updatePersonnel(personnel);
    }
}
