package com.khg.jpahibernate;

import com.khg.jpahibernate.entity.Course;
import com.khg.jpahibernate.entity.Review;
import com.khg.jpahibernate.entity.Student;
import com.khg.jpahibernate.repository.CourseRepository;
import com.khg.jpahibernate.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Student student = new Student("Kaan");
		Course course1 = new Course("Spring Boot");
		Course course2 = new Course("Spring Boot - 2");
		List<Course> courses = new ArrayList<>();
		courses.add(course1);
		courses.add(course2);
		studentRepository.saveStudentAndCourses(student, courses);
	}
}
