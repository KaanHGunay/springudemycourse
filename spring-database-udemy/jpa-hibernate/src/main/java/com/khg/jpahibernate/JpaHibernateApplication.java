package com.khg.jpahibernate;

import com.khg.jpahibernate.entity.Course;
import com.khg.jpahibernate.entity.Review;
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
		Course course = courseRepository.findById(1001L);
		List<Review> reviews = new ArrayList<>();
		Review review1 = new Review("5", "Great");
		Review review2 = new Review("4", "Good");
		reviews.add(review1);
		reviews.add(review2);
		courseRepository.addReviewsCourse(course, reviews);
	}
}
