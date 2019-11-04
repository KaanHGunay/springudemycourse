package com.khg.springdemoapp.model.repository;

import com.khg.springdemoapp.model.entity.City;
import com.khg.springdemoapp.model.entity.Personnel;
import com.khg.springdemoapp.model.entity.utils.Rutbe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Personel ile ilgili veri tabanı sorguları
 */
public interface PersonnelRepository extends JpaRepository<Personnel, Integer> {

    /**
     * İsim ve soyisim ile personel sorgusu
     * @param name Personel ismi
     * @param surname Personel Soyismi
     * @return Parametre olarak verilen isim ve soyisme sahip tüm personel
     */
    List<Personnel> findByNameAndSurname(String name, String surname);

    /**
     * Doğum yeri ile personel sorgusu
     * @param city Personelin doğum yeri
     * @return Parametre olarak verilen doğum yerine sahip tüm personel
     */
    List<Personnel> findByPlaceOfBirth(City city);

    /**
     * Rütbe ile personel sorgusu
     * @param rutbe Bulunmak istenen personelin rütbesi
     * @return Parametre olarak verilen rütbeye sahip tüm personel
     */
    List<Personnel> findByRutbe(Rutbe rutbe);

    void deleteById(Long id);
}
