package com.springboot.rest_api.survey;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collector;

import org.springframework.stereotype.Service;

@Service
public class SurveyService {
	private static List<Survey> surveys = new ArrayList<Survey>();
	static {
		Question question1 = new Question("Question1", "Most Popular Cloud Platform Today",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		Question question2 = new Question("Question2", "Fastest Growing Cloud Platform",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
		Question question3 = new Question("Question3", "Most Popular DevOps Tool",
				Arrays.asList("Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

		List<Question> questions = new ArrayList<>(Arrays.asList(question1, question2, question3));

		Survey survey = new Survey("Survey1", "My Favorite Survey", "Description of the Survey", questions);

		surveys.add(survey);
	}

	public List<Survey> retriveAllSurveys() {
		return surveys;
	}

	public Survey retriveSurveyById(String surveyId) {
		Predicate<? super Survey> predicate = survey -> survey.getId().equalsIgnoreCase(surveyId);
		Optional<Survey> optionalSurvey = surveys.stream().filter(predicate).findFirst();
		if (optionalSurvey.isEmpty())
			return null;
		return optionalSurvey.get();
	}

	public List<Question> retriveAllSurveyQuestions(String surveyId) {
		;
		Survey survey = retriveSurveyById(surveyId);
		if (survey == null)
			return null;
		return survey.getQuestions();
	}

	public Question retriveSpecificSurveyQuestion(String surveyId, String questionId) {
		List<Question> surveyQuestions = retriveAllSurveyQuestions(surveyId);
		if (surveyQuestions == null)
			return null;
		Optional<Question> optionalQuestion = surveyQuestions.stream()
				.filter(q -> q.getId().equalsIgnoreCase(questionId)).findFirst();
		if (optionalQuestion.isEmpty())
			return null;
		return optionalQuestion.get();
	}

	public String addNewSurveyQuestion(String surveyId, Question question) {
		List<Question> questions = retriveAllSurveyQuestions(surveyId);

		question.setId(generateRandom());
		questions.add(question);
		return question.getId();
	}

	private String generateRandom() {
		SecureRandom secureRandom = new SecureRandom();
		String randomId = new BigInteger(32, secureRandom).toString();
		return randomId;
	}

	public String deleteSurveyQuestion(String surveyId, String questionId) {
		List<Question> surveyQuestions = retriveAllSurveyQuestions(surveyId);
		if (surveyQuestions == null)
			return null;
		Predicate<? super Question> predicate = q -> q.getId().equalsIgnoreCase(questionId);
		boolean removed = surveyQuestions.removeIf(predicate);
		if (!removed)
			return null;

		return questionId;
	}

	public void updateSurveyQuestion(String surveyId, String questionId, Question question) {
		List<Question> questions = retriveAllSurveyQuestions(surveyId);
		questions.removeIf(q -> q.getId().equalsIgnoreCase(questionId));
		questions.add(question);
	}
}
