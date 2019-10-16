package com.khg.springdatabaseudemy;

import com.khg.springdatabaseudemy.entity.Person;
import com.khg.springdatabaseudemy.jdbc.PersonJdbcDao;
import com.khg.springdatabaseudemy.jpa.PersonJpaRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JPAUdemyApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonJpaRepo personJpaRepo;

	public static void main(String[] args) {
		SpringApplication.run(JPAUdemyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("10001 id person -> {}", personJpaRepo.findById(10001));
		personJpaRepo.deleteById(10001);
		logger.info("1004 id person insert -> {}", personJpaRepo.insertPerson(new Person(10004, "Kaan", "Ankara", new Date())));
		logger.info("Update 1001 id person -> {}", personJpaRepo.updatePerson(new Person(10002, "Test", "World", new Date())));
	}
}
