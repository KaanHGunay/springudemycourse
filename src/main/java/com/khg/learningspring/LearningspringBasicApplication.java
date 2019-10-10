package com.khg.learningspring;

import com.khg.learningspring.basic.BinarySearchImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // Spring Boot olmadan Spring Framework u kullanmak içinm
@ComponentScan("com.khg.learningspring")  // Componentlerş bulması için
public class LearningspringBasicApplication {

	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext applicationContext =
					new AnnotationConfigApplicationContext(LearningspringBasicApplication.class)) {
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		BinarySearchImpl binarySearch2 = applicationContext.getBean(BinarySearchImpl.class);
		// Scope Prototype olması nedeniyle iki farklı instance oluşturulacak
		int a = binarySearch.binarySearch(new int[] {2, 6, 5}, 4);}
	}

}
