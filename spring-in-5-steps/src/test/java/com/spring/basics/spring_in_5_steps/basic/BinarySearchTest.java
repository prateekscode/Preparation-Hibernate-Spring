package com.spring.basics.spring_in_5_steps.basic;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.basics.spring_in_5_steps.SpringIn5StepsBasicApplication;

//Load the context
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringIn5StepsBasicApplication.class)
public class BinarySearchTest {
	
	//get this bean from the context
	@Autowired
	BinaySearchImpl binaySearch;
	
	@Test
	public void testBasicScenario() {
		//call method on binarysearch
		int actualResult = binaySearch.binarySearch(new int[] {}, 5);

		//check if the value is correct
		assertEquals(3, actualResult);		
	}

}
