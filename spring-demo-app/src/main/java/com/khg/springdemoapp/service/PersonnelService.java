package com.khg.springdemoapp.service;

import com.khg.springdemoapp.model.entity.Personnel;
import com.khg.springdemoapp.model.entity.utils.Rank;
import com.khg.springdemoapp.model.entity.utils.RankConverter;
import com.khg.springdemoapp.model.repository.CityRepository;
import com.khg.springdemoapp.model.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnelService {

    private PersonnelRepository personnelRepository;

    private final CityRepository cityRepository;

    @Autowired
    public PersonnelService(PersonnelRepository personnelRepository, CityRepository cityRepository) {
        this.personnelRepository = personnelRepository;
        this.cityRepository = cityRepository;
    }

    public List<Personnel> getAllPersonnel() {
        return personnelRepository.findAll();
    }

    public List<Personnel> getAllPersonnelForACity(String city) {
        return personnelRepository.findByPlaceOfBirth(cityRepository.findByName(city));
    }

    public List<Personnel> getAllPersonnelForRank(String rankName) {
        RankConverter rankConverter = new RankConverter();
        Rank rank = rankConverter.convertToEntityAttribute(rankName);
        return personnelRepository.findByRank(rank);
    }

    public List<Personnel> searchWithNameAndSurname(String name, String surname) {
        return personnelRepository.findByNameAndSurname(name, surname);
    }
}
