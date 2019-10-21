package com.khg.jpahibernate.repository;

import com.khg.jpahibernate.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional  // Data manipulation için gerekli
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        entityManager.remove(course);
    }

    public Course save(Course course) {
        if(course.getId() == null) {
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }

        return course;
    }

    public void playWithEntityManager() {
        Course course = new Course("Test Data");
        entityManager.persist(course);
        entityManager.flush();  // Transaction bitmeden veri tabanına yaz

        course.setName("Test Data - Updated");
        entityManager.flush();

        Course course2 = new Course("Test Data 2");
        entityManager.persist(course2);
        entityManager.flush();
        entityManager.detach(course2);  // Burdan sonra ikinci nesneyi takip etmeyi bırak. Son değişiklik veritabanına kaydolmayacak.
        // entityManager.clear();  // Tüm nesnelerin takibini bırak

        course2.setName("Test Data 2- Updated");
        entityManager.flush();
    }
}
