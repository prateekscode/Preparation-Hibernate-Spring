package com.springboot.rest_api.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(controllers = SurveyResource.class)
@AutoConfigureMockMvc(addFilters = false)
class SurveyResourceTest {

	@MockitoBean
	private SurveyService surveyService;

	@Autowired
	private MockMvc mockMvc;

	private static String SPECIFIC_QUESTION_URL = "http://localhost:5555/surveys/Survey1/questions/Question2";
	private static String QUESTIONS_URL = "http://localhost:5555/surveys/Survey1/questions";

	@Test
	void retriveSpecificSurveyQuestion_404Scenario() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(SPECIFIC_QUESTION_URL)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(404, mvcResult.getResponse().getStatus());
	}

	@Test
	void retriveSpecificSurveyQuestion_basicScenario() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(SPECIFIC_QUESTION_URL)
				.accept(MediaType.APPLICATION_JSON);

		Question question = new Question("Question2", "Fastest Growing Cloud Platform",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");

		when(surveyService.retriveSpecificSurveyQuestion("Survey1", "Question2")).thenReturn(question);

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(mvcResult.getResponse().getContentAsString());
		System.out.println(mvcResult.getResponse().getStatus());
		String expectedResponse = """
				{
				"id":"Question2",
				"description":"Fastest Growing Cloud Platform",
				"options":["AWS","Azure","Google Cloud","Oracle Cloud"],
				"correctAnswer":"Google Cloud"
				}
				""";

		assertEquals(200, mvcResult.getResponse().getStatus());
		JSONAssert.assertEquals(expectedResponse, mvcResult.getResponse().getContentAsString(), false);
	}

//	addNewSurveyQuestion
	// POST
//	http://localhost:5555/surveys/Survey1/questions
//	201
//	http://localhost:5555/surveys/Survey1/questions/681363995
	@Test
	void addNewSurveyQuestion_basicScenario() throws Exception {
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

		when(surveyService.addNewSurveyQuestion(anyString(), any())).thenReturn("Some_Id");

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(QUESTIONS_URL).accept(MediaType.APPLICATION_JSON)
				.content(requestBody).contentType(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = mvcResult.getResponse();
		System.out.println(response.getHeader("Location"));
		assertEquals(201, response.getStatus());
	}
}
