package com.khg.learningspring;

import com.khg.learningspring.xml.XmlPersonDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LearningspringXmlApplication {
	private static Logger LOGGER = LoggerFactory.getLogger(LearningspringXmlApplication.class);

	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext applicationContext =
					new ClassPathXmlApplicationContext("applicationContext.xml")) {
			LOGGER.info("Beans Loaded -> {}", (Object) applicationContext.getBeanDefinitionNames());
			XmlPersonDao xmlPersonDao = applicationContext.getBean(XmlPersonDao.class);
			LOGGER.info("{} {}", xmlPersonDao, xmlPersonDao.getXmlJdbcConnection());
		}
	}
}
