package com.spring.basics.spring_in_5_steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.basics.spring_in_5_steps.cdi.SomeCdiBusiness;

@Configuration
@ComponentScan
public class SpringIn5StepsCdiApplication {
	private static Logger LOGGER = LoggerFactory.getLogger(SpringIn5StepsCdiApplication.class);

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringIn5StepsCdiApplication.class);
		SomeCdiBusiness cdiBusiness = applicationContext.getBean(SomeCdiBusiness.class);

		LOGGER.info("{} dao-{}", cdiBusiness, cdiBusiness.getCdidao());
	}

}
