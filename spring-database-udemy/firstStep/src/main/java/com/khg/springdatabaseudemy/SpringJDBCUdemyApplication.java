package com.khg.springdatabaseudemy;

import com.khg.springdatabaseudemy.entity.Person;
import com.khg.springdatabaseudemy.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

// @SpringBootApplication
public class SpringJDBCUdemyApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonJdbcDao personJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJDBCUdemyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", personJdbcDao.findAll());
		logger.info("10001 id person -> {}", personJdbcDao.findById(10001));
		logger.info("10001 id person deleted -> {}", personJdbcDao.deleteById(10001));
		logger.info("1004 id person insert -> {}", personJdbcDao.insertPerson(new Person(10004, "Kaan", "Ankara", new Date())));
		logger.info("Update 1001 id person -> {}", personJdbcDao.updatePerson(new Person(10002, "Test", "World", new Date())));
		logger.info("All users -> {}", personJdbcDao.findAll());
	}
}
