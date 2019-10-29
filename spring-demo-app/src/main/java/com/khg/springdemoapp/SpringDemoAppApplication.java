package com.khg.springdemoapp;

import com.khg.springdemoapp.model.entity.User;
import com.khg.springdemoapp.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemoAppApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*User user	= new User();
		user.setActive(true);
		user.setUsername("a");
		user.setPasswordWithBCrypt("a");
		user.setRoles("ADMIN");
		userRepository.save(user);*/
	}
}
