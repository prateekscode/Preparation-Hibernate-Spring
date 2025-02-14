package com.spring.basics.spring_in_5_steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.basics.componentscan.ComponentDAO;

@Configuration
@ComponentScan("com.spring.basics.componentscan")
public class SpringIn5StepsComponentScanApplication {
	private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsComponentScanApplication.class);

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringIn5StepsComponentScanApplication.class);
		ComponentDAO componentDAO = applicationContext.getBean(ComponentDAO.class);
		LOGGER.info("{}", componentDAO);
	}

}
