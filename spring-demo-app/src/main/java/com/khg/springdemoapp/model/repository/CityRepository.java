package com.khg.springdemoapp.model.repository;

import com.khg.springdemoapp.model.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
    City findByName(String name);
}
