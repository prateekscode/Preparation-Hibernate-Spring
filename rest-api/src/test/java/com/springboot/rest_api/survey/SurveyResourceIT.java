package com.springboot.rest_api.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Base64;

import org.springframework.http.HttpHeaders;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SurveyResourceIT {

	private static String SPECIFIC_QUESTION_URL = "/surveys/Survey1/questions/Question2";
	private static String QUESTIONS_URL = "/surveys/Survey1/questions";

	@Autowired
	private TestRestTemplate template;

	// ["""] text blocks feature since java 15

	@Test
	void retriveSpecificSurveyQuestion_basicScenario() throws JSONException {
		HttpHeaders headers = createHttpContentTypeAndAuthorizationHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<String>(null, headers);
		ResponseEntity<String> responseEntity = template.exchange(SPECIFIC_QUESTION_URL, HttpMethod.GET, httpEntity,
				String.class);

//		ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_QUESTION_URL, String.class);
		
		String expectedResponse = """
				{
				"id":"Question2",
				"description":"Fastest Growing Cloud Platform",
				"correctAnswer":"Google Cloud"
				}
				""";

		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);

		// [:"application/json"]
//		assertEquals(expectedResponse.trim(), responseEntity.getBody());
//		System.out.println(responseEntity.getBody());
//		System.out.println(responseEntity.getHeaders());
	}

	@Test
	void retriveAllSurveyQuestions_basicScenario() throws JSONException {
		ResponseEntity<String> responseEntity = template.getForEntity(QUESTIONS_URL, String.class);

		String expectedResponse = """
				[
				{
					"id": "Question1"
				},
				{
					"id": "Question2"
				},
				{
					"id": "Question3"
				}
				]""";

		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));
		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);

	}

	@Test
	void addNewSurveyQuestion_basicScenario() {
		String requestBody = """
				{
					"description": "Which is latest version of java released",
					"options": [
					"17",
					"20",
					"21",
					"24"
					],
					"correctAnswer": "24"
				}
				""";

		HttpHeaders headers = createHttpContentTypeAndAuthorizationHeaders();
		HttpEntity<String> httpEntity = new HttpEntity<String>(requestBody, headers);
		ResponseEntity<String> responseEntity = template.exchange(QUESTIONS_URL, HttpMethod.POST, httpEntity,
				String.class);

		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		String locationHeader = responseEntity.getHeaders().get("Location").get(0);
		assertTrue(locationHeader.contains("/surveys/Survey1/questions"));

		template.delete(locationHeader);
	}

	private HttpHeaders createHttpContentTypeAndAuthorizationHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Authorization", "Basic"+performBasicAuthEncoding("admin", "password"));
		return headers;
	}
	
	String performBasicAuthEncoding(String user, String password) {
		String combined =user+":"+password;
		//Base64 encoding => Bytes
		byte[] encodedBytes = Base64.getEncoder().encode(combined.getBytes());
		//Bytes => String
		return new String(encodedBytes);
	}
}
