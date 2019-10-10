package com.khg.learningspring;

import com.khg.learningspring.properties.ExternalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.khg.learningspring")
@PropertySource("classpath:app.properties")  // External Property File
public class LearningspringPropertiesApplication {
	private static Logger LOGGER = LoggerFactory.getLogger(LearningspringPropertiesApplication.class);

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext applicationContext =
					 new AnnotationConfigApplicationContext(LearningspringPropertiesApplication.class)) {
			ExternalService service = applicationContext.getBean(ExternalService.class);
			LOGGER.info("{}", service.returnServiceUrl());
		}
	}
}
