package com.springboot.learn_springboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {
	
	@Autowired
	private CurrencyServiceConfig config;
	
	@RequestMapping("/currency-configuration")
	public CurrencyServiceConfig retrieveAllCourses(){
		return config;
	}
}
