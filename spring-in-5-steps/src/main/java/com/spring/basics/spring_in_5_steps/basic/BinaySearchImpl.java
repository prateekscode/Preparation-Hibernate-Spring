package com.spring.basics.spring_in_5_steps.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BinaySearchImpl {
	
	private Logger logger=LoggerFactory.getLogger(BinaySearchImpl.class);
	
	@Autowired
	@Qualifier("bubble")
	private SortAlgorithm sortAlgorithm;
	

	public int binarySearch(int[] num, int numberToSearch){
		int[] sortNum=sortAlgorithm.sort(num);
		
		System.out.println(sortAlgorithm);
    	
    	//implementing sorting logic
    	//bubble sort algo
    	//search the array
        return 3;
    }
	
	@PostConstruct
	public void postConstruct() {
		logger.info("postConstruct");
	}
	
	@PreDestroy
	public void preDestroy() {
		logger.info("preDestroy");
	}
}
