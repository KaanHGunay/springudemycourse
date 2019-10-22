package com.khg.jpahibernate.repository;

import com.khg.jpahibernate.entity.Course;
import com.khg.jpahibernate.entity.Passport;
import com.khg.jpahibernate.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional  // Data manipulation için gerekli
public class StudentRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        entityManager.remove(student);
    }

    public Student save(Student student) {
        if(student.getId() == null) {
            entityManager.persist(student);
        } else {
            entityManager.merge(student);
        }

        return student;
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("Z1234569");
        entityManager.persist(passport);
        Student student = new Student("Mike");
        student.setPassport(passport);
        entityManager.persist(student);
    }

    public void saveStudentAndCourses(Student student, Course course) {
        if(student.getId() == null) {
            entityManager.persist(student);
        }
        if (course.getId() == null) {
            entityManager.persist(course);
        }
        course.addStudent(student);
        student.addCourse(course);
    }

    public void saveStudentAndCourses(Student student, List<Course> courses) {
        if(student.getId() == null) {
            entityManager.persist(student);
        }
        for(Course course:courses) {
            if (course.getId() == null) {
                entityManager.persist(course);
            }
            course.addStudent(student);
            student.addCourse(course);
        }
    }
}
