package com.springboot.rest_api.survey;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class JsonAssertTest {

	@Test
	void jsonAssert_learning_Basics() throws JSONException {
		String expectedResponse = """
				{"id":"Question2","description":"Fastest Growing Cloud Platform","options":["AWS","Azure","Google Cloud","Oracle Cloud"],"correctAnswer":"Google Cloud"}
							""";
		
		String actualResponse = """
				{"id":"Question2",
				"description":"Fastest Growing Cloud Platform",
				"options":["AWS","Azure","Google Cloud","Oracle Cloud"],
				"correctAnswer":"Google Cloud"}
				""";
		
		//jsonAssert ignores the spaces and returns exactly what didn't match. 
		//or if we want to check all things then we make that true if we want to check subset then that becomes false
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}

}
