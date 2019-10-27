package com.khg.springdemoapp.model.repository;

import com.khg.springdemoapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
