package com.khg.springdemoapp.controller;

import com.khg.springdemoapp.model.dao.PersonnelDao;
import com.khg.springdemoapp.model.entity.Personnel;
import com.khg.springdemoapp.service.PersonnelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Personel ile ilgili tüm sorgulamalrın yapıldığı controller
 * @require Admin Role
 */
@RestController
@RequestMapping("personnel")
public class PersonnelController {
    private final PersonnelService personnelService;

    public PersonnelController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    /**
     * Tüm personel listesinin sorgulanması için kullanılır
     * @return all personnel list
     */
    @GetMapping("all-personnel")
    public List<Personnel> getAllPersonnel() {
        return personnelService.getAllPersonnel();
    }

    /**
     * Doğum yer şehri üzerinden personel sorgulama
     * @param city personelin doğum yeri
     * @return doğum yeri parametre ile uyan tüm personel listesi
     */
    @GetMapping("all-personnel-city")
    public List<Personnel> getAllPersonnelForACity(@RequestParam String city) {
        return personnelService.getAllPersonnelForACity(city);
    }

    /**
     * Rütbe ile personel sorgusu
     * @param rutbe sorgulanmak istenen rütbe
     * @return parametre olarak verilen rütbede ki tüm personel listesi
     */
    @GetMapping("all-personnel-rank")
    public List<Personnel> getAllPersonnelForRank(@RequestParam String rutbe) {
        return personnelService.getAllPersonnelForRank(rutbe);
    }

    /**
     * İsim soyisim ile personel sorgusu
     * @param name personelin ismi
     * @param surname personelin soyismi
     * @return parametre olarak verilen isim soyisme sahip tüm personel listesi
     */
    @GetMapping("search-personnel")
    public List<Personnel> getAllPersonnelForRank(@RequestParam String name, @RequestParam String surname) {
        return personnelService.searchWithNameAndSurname(name, surname);
    }

    /**
     * Yeni personel ekleme
     * @param personnel eklenmek istenen personeli temsil eden json
     */
    @PostMapping(value = "/add-personnel", consumes = "application/json", produces = "application/json")
    public void addPersonnel(@RequestBody PersonnelDao personnel) {
        personnelService.addPersonnel(personnel);
    }

    /**
     * Personel güncelleme
     * @param personnel güncellenmek istenen personel json dosyası
     */
    @PutMapping(value = "/update-personnel", consumes = "application/json", produces = "application/json")
    public void updatePersonnel(@RequestBody PersonnelDao personnel) {
        personnelService.updatePersonnel(personnel);
    }
}
