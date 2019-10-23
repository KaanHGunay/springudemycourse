package com.khg.jpahibernate.repository;

import com.khg.jpahibernate.JpaHibernateApplication;
import com.khg.jpahibernate.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
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

    @Test
    public void saveAndUpdate_Test() {
        Course course = new Course("English");
        springDataRepository.save(course);

        course.setName("Updated Name");
        springDataRepository.save(course);

        logger.info("All courses -> {}", springDataRepository.findAll());
        logger.info("Count courses -> {}", springDataRepository.count());
    }

    @Test  // Sort Classı hata veriyor
    public void sorting_Test() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        logger.info("All courses -> {}", springDataRepository.findAll(sort));
        logger.info("Count courses -> {}", springDataRepository.count());
    }

    /**
     * Tüm veriyi vermek yerine sayfa döndürmek için kullanılır.
     */
    @Test
    public void pagination() {
        PageRequest pageRequest = PageRequest.of(0, 3);

        Page<Course> firstPage = springDataRepository.findAll(pageRequest);
        logger.info("First Page -> {} ", firstPage.getContent());

        Pageable secondPageable = firstPage.nextPageable();
        Page<Course> secondPage = springDataRepository.findAll(secondPageable);
        logger.info("Second Page -> {} ", secondPage.getContent());
    }
}