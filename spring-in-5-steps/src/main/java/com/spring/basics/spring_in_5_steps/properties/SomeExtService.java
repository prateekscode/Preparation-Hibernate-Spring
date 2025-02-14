package com.spring.basics.spring_in_5_steps.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SomeExtService {
	//from property file
	@Value("${external.service.url}")
	private String url;
	
	public String returnServiceURL() {
		return url;
	}
}
