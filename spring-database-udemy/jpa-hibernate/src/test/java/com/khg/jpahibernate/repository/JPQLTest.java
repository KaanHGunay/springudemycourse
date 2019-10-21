package com.khg.jpahibernate.repository;

import com.khg.jpahibernate.JpaHibernateApplication;
import com.khg.jpahibernate.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateApplication.class)
public class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;

    @Test
    public void query_Basic() {
        Query query = entityManager.createNamedQuery("query_get_all_courses");
        List courses = query.getResultList();
        logger.info("Select c from Course c -> {}", courses);
    }

    @Test
    public void query_WithType() {
        TypedQuery<Course> query = entityManager.createNamedQuery("query_get_all_courses", Course.class);
        List<Course> courses = query.getResultList();
        logger.info("Select c from Course c -> {}", courses);
    }

    @Test
    public void query_WithWhere() {
        TypedQuery<Course> query =
                entityManager.createNamedQuery("query_get_start_with_t", Course.class);
        List<Course> courses = query.getResultList();
        logger.info("Select c from Course c where name like 'T%' -> {}", courses);
    }
}