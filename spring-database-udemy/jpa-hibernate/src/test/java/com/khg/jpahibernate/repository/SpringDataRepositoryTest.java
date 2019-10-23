package com.khg.jpahibernate.repository;

import com.khg.jpahibernate.JpaHibernateApplication;
import com.khg.jpahibernate.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateApplication.class)
public class SpringDataRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SpringDataRepository springDataRepository;

    @Test
    public void findByIdPresent_Test() {
        Optional<Course> courseOptional = springDataRepository.findById(1001L);
        assertTrue(courseOptional.isPresent());
    }

    @Test
    public void findByIdNotPresent_Test() {
        Optional<Course> courseOptional = springDataRepository.findById(2001L);
        assertFalse(courseOptional.isPresent());
    }
}