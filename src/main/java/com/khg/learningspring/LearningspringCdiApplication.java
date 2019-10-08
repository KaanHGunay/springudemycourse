package com.khg.learningspring;

import com.khg.learningspring.cdi.SomeCdiBusiness;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LearningspringCdiApplication {
	private static Logger LOGGER = LoggerFactory.getLogger(LearningspringCdiApplication.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(LearningspringCdiApplication.class, args);
		SomeCdiBusiness someCdiBusiness = applicationContext.getBean(SomeCdiBusiness.class);

		LOGGER.info("{}", someCdiBusiness);
	}

}
