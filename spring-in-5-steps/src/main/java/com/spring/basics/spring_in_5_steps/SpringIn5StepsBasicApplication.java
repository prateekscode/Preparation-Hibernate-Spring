package com.spring.basics.spring_in_5_steps;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.basics.spring_in_5_steps.basic.BinaySearchImpl;

@Configuration
@ComponentScan("com.spring.basics.spring_in_5_steps")
public class SpringIn5StepsBasicApplication {

	public static void main(String[] args) {
//		BinaySearchImpl binaySearch = new BinaySearchImpl(new BubbleSortAlgo());
//		Application Context
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringIn5StepsBasicApplication.class);
		BinaySearchImpl binaySearch = applicationContext.getBean(BinaySearchImpl.class);
		BinaySearchImpl binaySearch1 = applicationContext.getBean(BinaySearchImpl.class);
		
		System.out.println(binaySearch);
		System.out.println(binaySearch1);
		
		int result = binaySearch.binarySearch(new int[] { 12, 6, 4 }, 3);
		System.out.println(result);

	}

}
