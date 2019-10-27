package com.khg.springdemoapp.model.repository;

import com.khg.springdemoapp.model.entity.City;
import com.khg.springdemoapp.model.entity.Personnel;
import com.khg.springdemoapp.model.entity.utils.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonnelRepository extends JpaRepository<Personnel, Integer> {
    List<Personnel> findByNameAndSurname(String name, String surname);
    List<Personnel> findByPlaceOfBirth(City city);
    List<Personnel> findByRank(Rank rank);
}
