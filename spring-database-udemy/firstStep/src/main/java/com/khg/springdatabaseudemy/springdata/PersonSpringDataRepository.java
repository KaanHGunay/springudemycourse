package com.khg.springdatabaseudemy.springdata;

import com.khg.springdatabaseudemy.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {  // Integer is type of id

}
