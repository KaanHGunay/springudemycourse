package com.khg.springdemoapp.service;

import com.khg.springdemoapp.model.dao.PersonnelConverter;
import com.khg.springdemoapp.model.dao.PersonnelDao;
import com.khg.springdemoapp.model.entity.Personnel;
import com.khg.springdemoapp.model.entity.utils.Rutbe;
import com.khg.springdemoapp.model.entity.utils.RutbeConverter;
import com.khg.springdemoapp.model.repository.CityRepository;
import com.khg.springdemoapp.model.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class PersonnelService {

    private PersonnelRepository personnelRepository;

    private final CityRepository cityRepository;

    private PersonnelConverter personnelConverter;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    public PersonnelService(PersonnelRepository personnelRepository, CityRepository cityRepository, PersonnelConverter personnelConverter) {
        this.personnelRepository = personnelRepository;
        this.cityRepository = cityRepository;
        this.personnelConverter = personnelConverter;
    }

    public List<Personnel> getAllPersonnel() {
        return personnelRepository.findAll();
    }

    public List<Personnel> getAllPersonnelForACity(String city) {
        return personnelRepository.findByPlaceOfBirth(cityRepository.findByName(city));
    }

    public List<Personnel> getAllPersonnelForRank(String rankName) {
        RutbeConverter rutbeConverter = new RutbeConverter();
        Rutbe rutbe = rutbeConverter.convertToEntityAttribute(rankName);
        return personnelRepository.findByRutbe(rutbe);
    }

    public List<Personnel> searchWithNameAndSurname(String name, String surname) {
        return personnelRepository.findByNameAndSurname(name, surname);
    }

    public void addPersonnel(PersonnelDao personnelDao) {
        Personnel personnel = personnelConverter.convertFromDaoToPersonnel(personnelDao);
        personnelRepository.save(personnel);
    }

    public void updatePersonnel(PersonnelDao personnelDao) {
        Personnel personnel = personnelConverter.convertFromDaoToPersonnel(personnelDao);
        personnelRepository.save(personnel);
    }
}
