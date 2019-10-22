package com.khg.jpahibernate.repository;

import com.khg.jpahibernate.JpaHibernateApplication;
import com.khg.jpahibernate.entity.Course;
import com.khg.jpahibernate.entity.Passport;
import com.khg.jpahibernate.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaHibernateApplication.class)
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EntityManager entityManager;

    /**
     * Eğer herhangi bir ayar yapılmazsa one to one ilişi eager fetch yapar
     * Lazy fetch yapılması isteniyorsa Entity kısmında belirtilmeli
     * Ayrıca kullanılan metot transactional olmalıdır.
     */
    @Test
    @Transactional
    public void retrieveStudentWithPassport() {
        Student student = entityManager.find(Student.class, 2001L);
        logger.info("Student -> {}", student);
        logger.info("Passport -> {}", student.getPassport());  // Her one to one relation eager fetch yapar
    }

    @Test
    @Transactional
    public void retrievePassportWithStudent() {
        Passport passport = entityManager.find(Passport.class, 4001L);
        logger.info("Passport -> {}", passport);
        logger.info("Student -> {}", passport.getStudent());
    }
}