package com.khg.jpahibernate;

import com.khg.jpahibernate.entity.FullTimeEmployee;
import com.khg.jpahibernate.entity.PartTimeEmployee;
import com.khg.jpahibernate.repository.CourseRepository;
import com.khg.jpahibernate.repository.EmployeeRepository;
import com.khg.jpahibernate.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		employeeRepository.insertEmployee(new PartTimeEmployee("TestPartTimeEmployee", new BigDecimal("50")));
		employeeRepository.insertEmployee(new FullTimeEmployee("TestFullTimeEmployee", new BigDecimal("10000")));
		logger.info("FullTimeEmployee employees -> {}", employeeRepository.retrieveFullTimeEmployees());
	}
}
