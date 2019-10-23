package com.khg.jpahibernate.repository;

import com.khg.jpahibernate.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataRepository extends JpaRepository<Course, Long> {
}
