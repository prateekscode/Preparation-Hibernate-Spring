package com.spring.basics.spring_in_5_steps;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.spring.basics.spring_in_5_steps.basic.BinaySearchImpl;
import com.spring.basics.spring_in_5_steps.properties.SomeExtService;

@Configuration
@ComponentScan("com.spring.basics.spring_in_5_steps")
//app.properties
@PropertySource("classpath:app.properties")
public class SpringIn5StepsPropertiesApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringIn5StepsPropertiesApplication.class);
		SomeExtService extService= applicationContext.getBean(SomeExtService.class);
		System.out.println(extService+"  "+extService.returnServiceURL());

	}

}
