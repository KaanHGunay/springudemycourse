package com.khg.springdatabaseudemy;

import com.khg.springdatabaseudemy.entity.Person;
import com.khg.springdatabaseudemy.springdata.PersonSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringDemoUdemyApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonSpringDataRepository personSpringDataRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoUdemyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("10001 id person -> {}", personSpringDataRepository.findById(10001));
		personSpringDataRepository.deleteById(10001);
		logger.info("1004 id person insert -> {}", personSpringDataRepository.save(new Person(10004, "Kaan", "Ankara", new Date())));
		logger.info("Update 1001 id person -> {}", personSpringDataRepository.save(new Person(10002, "Test", "World", new Date())));
		logger.info("All users -> {}", personSpringDataRepository.findAll());
	}
}
