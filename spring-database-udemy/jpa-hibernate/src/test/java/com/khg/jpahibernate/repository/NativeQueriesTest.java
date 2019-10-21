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
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateApplication.class)
public class NativeQueriesTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;

    @Test
    public void query_Basic() {
        Query query = entityManager.createNativeQuery("select * from course");
        List courses = query.getResultList();
        logger.info("Select c from Course c -> {}", courses);
    }

    @Test
    public void query_WithType() {
        Query query = entityManager.createNativeQuery("select * from course where id = ?", Course.class);
        query.setParameter(1, 1001L);  // Starts with 1
        Course course = (Course) query.getSingleResult();
        logger.info("Select c from Course c -> {}", course);
    }

    @Test
    public void query_WithType_NamedParams() {
        Query query = entityManager.createNativeQuery("select * from course where id = :id", Course.class);
        query.setParameter("id", 1001L);
        Course course = (Course) query.getSingleResult();
        logger.info("Select c from Course c -> {}", course);
    }

    @Test
    @Transactional
    public void query_toUpdate() {
        Query query = entityManager.createNativeQuery("update course set last_updated_date=sysdate");
        int numberOfEffectedRows = query.executeUpdate();
        logger.info("numberOfEffectedRows -> {}", numberOfEffectedRows);
    }
}