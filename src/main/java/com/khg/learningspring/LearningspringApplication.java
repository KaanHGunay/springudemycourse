package com.khg.learningspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LearningspringApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(LearningspringApplication.class, args);
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		int a = binarySearch.binarySearch(new int[] {2, 6, 5}, 4);
	}

}
