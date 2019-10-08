package com.khg.learningspring;

import com.khg.component.ComponentDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.khg.component")  // ComponentDao class ını bulabilmesi için - No Beans Found Exception
public class LearningspringComponentScanApplication {
	private static Logger LOGGER = LoggerFactory.getLogger(LearningspringComponentScanApplication.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(LearningspringComponentScanApplication.class, args);
		ComponentDao componentDao = applicationContext.getBean(ComponentDao.class);

		LOGGER.info("{}", componentDao);
	}

}
