package com.khg.springdemoapp.model.dao;

import com.khg.springdemoapp.model.entity.Personnel;
import com.khg.springdemoapp.model.entity.utils.RutbeConverter;
import com.khg.springdemoapp.model.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * Personnel {@link com.khg.springdemoapp.model.entity.Personnel} ile
 * PersonnelDao {@link com.khg.springdemoapp.model.dao.PersonnelDao} arasında dönüşüm yapmak için kullanılır.
 */
@Component
public class PersonnelConverter {

    private final CityRepository cityRepository;

    @Autowired
    public PersonnelConverter(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    /**
     * PersonnelDao to Personnel
     * @param personnelDao personnel e dönüştürülecek personnelDao nesnesi
     * @return dönüşüm uygulanmış personnel nesnesi
     */
    public Personnel convertFromDaoToPersonnel(@NonNull PersonnelDao personnelDao) {
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

    /**
     * Personnel to PersonnelDao
     * @param personnel personnelDao ya dönüştürülecek personnel nesnesi
     * @return dönüşüm uygulanmış personnelDao nesnesi
     */
    public PersonnelDao convertToPersonnelToDao(@NonNull Personnel personnel) {
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