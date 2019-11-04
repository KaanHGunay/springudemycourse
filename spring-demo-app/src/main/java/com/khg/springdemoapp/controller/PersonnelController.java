package com.khg.springdemoapp.controller;

import com.khg.springdemoapp.model.dao.PersonnelDao;
import com.khg.springdemoapp.model.entity.Personnel;
import com.khg.springdemoapp.security.AuthenticationFacade;
import com.khg.springdemoapp.service.PersonnelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Personel ile ilgili tüm sorgulamalrın yapıldığı controller
 * @require Admin Role
 */
@RestController
@RequestMapping("personnel")
public class PersonnelController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final PersonnelService personnelService;

    private final AuthenticationFacade currentUser;

    @Autowired
    public PersonnelController(PersonnelService personnelService, AuthenticationFacade currentUser) {
        this.personnelService = personnelService;
        this.currentUser = currentUser;
    }

    /**
     * Tüm personel listesinin sorgulanması için kullanılır
     * @return all personnel list
     */
    @GetMapping("all-personnel")
    public List<Personnel> getAllPersonnel() {
        logger.info("Got all personnel by {}", currentUser.getAuthentication().getName());
        return personnelService.getAllPersonnel();
    }

    /**
     * Doğum yer şehri üzerinden personel sorgulama
     * @param city personelin doğum yeri
     * @return doğum yeri parametre ile uyan tüm personel listesi
     */
    @GetMapping("all-personnel-city")
    public List<Personnel> getAllPersonnelForACity(@RequestParam String city) {
        logger.info("Got all personnel for city of {} by {}", city, currentUser.getAuthentication().getName());
        return personnelService.getAllPersonnelForACity(city);
    }

    /**
     * Rütbe ile personel sorgusu
     * @param rutbe sorgulanmak istenen rütbe
     * @return parametre olarak verilen rütbede ki tüm personel listesi
     */
    @GetMapping("all-personnel-rank")
    public List<Personnel> getAllPersonnelForRank(@RequestParam String rutbe) {
        logger.info("Got all personnel who have {} rank by {}", rutbe, currentUser.getAuthentication().getName());
        return personnelService.getAllPersonnelForRank(rutbe);
    }

    /**
     * İsim soyisim ile personel sorgusu
     * @param name personelin ismi
     * @param surname personelin soyismi
     * @return parametre olarak verilen isim soyisme sahip tüm personel listesi
     */
    @GetMapping("search-personnel")
    public List<Personnel> searchPersonnel(@RequestParam String name, @RequestParam String surname) {
        logger.info("Searched personnel who have name {} and surname {} by {}", name, surname, currentUser.getAuthentication().getName());
        return personnelService.searchWithNameAndSurname(name, surname);
    }

    /**
     * Yeni personel ekleme
     * @param personnel eklenmek istenen personeli temsil eden json
     */
    @PostMapping(value = "/add-personnel", consumes = "application/json", produces = "application/json")
    public void addPersonnel(@RequestBody PersonnelDao personnel) {
        logger.info("New personnel who has {} batch number added by {}", personnel.getBatchNumber(), currentUser.getAuthentication().getName());
        personnelService.addPersonnel(personnel);
    }

    /**
     * Personel güncelleme
     * @param personnel güncellenmek istenen personel json dosyası
     */
    @PutMapping(value = "/update-personnel", consumes = "application/json", produces = "application/json")
    public void updatePersonnel(@RequestBody PersonnelDao personnel) {
        logger.info("Personnel who has {} batch number updated by {}", personnel.getBatchNumber(), currentUser.getAuthentication().getName());
        personnelService.updatePersonnel(personnel);
    }
}
