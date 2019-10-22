package com.khg.jpahibernate.repository;

import com.khg.jpahibernate.JpaHibernateApplication;
import com.khg.jpahibernate.entity.Course;
import com.khg.jpahibernate.entity.Student;
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

    @Test
    public void query_CoursesWithoutStudents() {
        TypedQuery<Course> query =
                entityManager.createQuery("select c from Course c where c.students is empty", Course.class);
        List<Course> courses = query.getResultList();
        logger.info("query_CoursesWithoutStudents -> {}", courses);
    }

    @Test
    public void query_CoursesAtLeast2Students() {
        TypedQuery<Course> query =
                entityManager.createQuery("select c from Course c where c.students.size >= 1", Course.class);
        List<Course> courses = query.getResultList();
        logger.info("query_CoursesAtLeast2Students -> {}", courses);
    }

    @Test
    public void query_CoursesOrderBy() {
        TypedQuery<Course> query =
                entityManager.createQuery("select c from Course c order by c.students.size desc", Course.class);
        List<Course> courses = query.getResultList();
        logger.info("query_CoursesOrderBy -> {}", courses);
    }

    @Test
    public void query_Like() {
        TypedQuery<Student> query =
                entityManager.createQuery("select s from Student s where s.passport.number like '%123%'", Student.class);
        List<Student> courses = query.getResultList();
        logger.info("query_Like -> {}", courses);
    }

    @Test
    public void join(){
        Query query = entityManager.createQuery("Select c, s from Course c JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Results Size -> {}", resultList.size());
        for(Object[] result:resultList){
            logger.info("Course -> {} Student -> {}", result[0], result[1]);
        }
    }

    @Test
    public void left_join(){
        Query query = entityManager.createQuery("Select c, s from Course c LEFT JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Results Size -> {}", resultList.size());
        for(Object[] result:resultList){
            logger.info("Course -> {} Student -> {}", result[0], result[1]);
        }
    }

    @Test
    public void cross_join(){
        Query query = entityManager.createQuery("Select c, s from Course c, Student s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Results Size -> {}", resultList.size());
        for(Object[] result:resultList){
            logger.info("Course -> {} Student -> {}", result[0], result[1]);
        }
    }
}