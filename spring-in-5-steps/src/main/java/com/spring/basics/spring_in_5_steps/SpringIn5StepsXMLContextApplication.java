package com.spring.basics.spring_in_5_steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.basics.spring_in_5_steps.xml.XMLPersonDAO;

public class SpringIn5StepsXMLContextApplication {
	private static Logger logger = LoggerFactory.getLogger(SpringIn5StepsXMLContextApplication.class);
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		
		logger.info("Beans Loaded -> {}",(Object)applicationContext.getBeanDefinitionNames());
//		Beans Loaded -> [xmlJdbcConnection, xmlPersonDAO]
		
		XMLPersonDAO personDAO = applicationContext.getBean(XMLPersonDAO.class);
		System.out.println(personDAO);

		logger.info("{} -- {}", personDAO, personDAO.getXmlJdbcConnection());
	}

}
