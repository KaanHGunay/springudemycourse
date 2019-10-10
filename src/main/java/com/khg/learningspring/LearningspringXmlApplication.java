package com.khg.learningspring;

import com.khg.learningspring.xml.XmlPersonDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LearningspringXmlApplication {

	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext applicationContext =
					new ClassPathXmlApplicationContext("applicationContext.xml")) {
			XmlPersonDao xmlPersonDao = applicationContext.getBean(XmlPersonDao.class);
			System.out.println(xmlPersonDao.getXmlJdbcConnection());
		}
	}
}
