package com.khg.springdemoapp.model.repository;

import com.khg.springdemoapp.model.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Doğum yeri olarak kullanılan şehir değişkeninin veri tabanı sorguları
 */
public interface CityRepository extends JpaRepository<City, Long> {
    /**
     * İsim ile şehir sorgusu
     * @param name Şehrin ismi
     * @return City
     */
    City findByName(String name);
}
