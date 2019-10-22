package com.khg.jpahibernate.repository;

import com.khg.jpahibernate.entity.Course;
import com.khg.jpahibernate.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Transactional isolation transaction anında olabilecek veri bozulmaları için ayardır
 * Burada her türlü sorunun SERIALIZABLE çözmektedeir ancak performans olarak yavaştır
 * transaction anında tüm diğer transactionları durdurur bekletir. En kullanılan ise
 * READ_COMMITTED hızlıdır sorun çıkma olasılığı mevcuttur ama az.
 */
@Repository
@Transactional(isolation = Isolation.READ_COMMITTED)  // Data manipulation için gerekli
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

        Course course1 = findById(1001L);
        course1.setName("Changed Test Data");
    }

    public void playWithEntityManager_old() {
        Course course = new Course("Test Data");
        entityManager.persist(course);
        entityManager.flush();  // Transaction bitmeden veri tabanına yaz

        course.setName("Test Data - Updated");
        entityManager.refresh(course);  // Nesneyi veri tabanında ki haline getirmek için kullanılır
        entityManager.flush();

        Course course2 = new Course("Test Data 2");
        entityManager.persist(course2);
        entityManager.flush();
        entityManager.detach(course2);  // Burdan sonra ikinci nesneyi takip etmeyi bırak. Son değişiklik veritabanına kaydolmayacak.
        // entityManager.clear();  // Tüm nesnelerin takibini bırak

        course2.setName("Test Data 2- Updated");
        entityManager.flush();
    }

    public void addReviewsCourse(Course course, List<Review> reviews) {
        for(Review review : reviews) {
            course.addReview(review);
            review.setCourse(course);
            entityManager.persist(review);
        }
    }
}
