package com.khg.springdemoapp.model.dao;

import com.khg.springdemoapp.model.entity.Personnel;
import com.khg.springdemoapp.model.entity.utils.RutbeConverter;
import com.khg.springdemoapp.model.repository.CityRepository;
import com.khg.springdemoapp.model.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonnelConverter {

    @Autowired
    private PersonnelRepository personnelRepository;

    @Autowired
    private CityRepository cityRepository;

    public Personnel convertFromDaoToPersonnel(PersonnelDao personnelDao) {
        Personnel personnel = new Personnel();
        personnel.setId(personnelDao.getId());
        personnel.setBatchNumber(personnelDao.getBatchNumber());
        personnel.setName(personnelDao.getName());
        personnel.setSurname(personnelDao.getSurname());
        personnel.setPlaceOfBirth(cityRepository.findByName(personnelDao.getPlaceOfBirth()));
        RutbeConverter rutbeConverter = new RutbeConverter();
        personnel.setRutbe(rutbeConverter.convertToEntityAttribute(personnelDao.getRutbe()));
        personnel.setIsActive(personnelDao.getIsActive());
        return personnel;
    }

    public PersonnelDao convertToPersonnelToDao(Personnel personnel) {
        PersonnelDao personnelDao = new PersonnelDao();
        personnelDao.setId(personnel.getId());
        personnelDao.setBatchNumber(personnel.getBatchNumber());
        personnelDao.setName(personnel.getName());
        personnelDao.setSurname(personnel.getSurname());
        RutbeConverter rutbeConverter = new RutbeConverter();
        personnelDao.setRutbe(rutbeConverter.convertToDatabaseColumn(personnel.getRutbe()));
        personnelDao.setIsActive(personnel.getIsActive());
        return personnelDao;
    }
}