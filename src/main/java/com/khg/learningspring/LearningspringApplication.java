package com.khg.learningspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningspringApplication {

	BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSort());
	int a = binarySearch.binarySearch(new int[] {2, 6, 5}, 4);

	public static void main(String[] args) {
		SpringApplication.run(LearningspringApplication.class, args);
	}

}
