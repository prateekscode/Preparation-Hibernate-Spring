package com.map;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class QuestionOTM {
	@Id
	@Column(name = "question_id")
	private int questionId;
	private String question;
	
//	 make the entity cascade so all of its related entities will updated. 
	@OneToMany(mappedBy = "question",cascade=CascadeType.ALL)
	List<AnswerOTM> answers;
	
	public QuestionOTM() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<AnswerOTM> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerOTM> answers) {
		this.answers = answers;
	}

	public QuestionOTM(int questionId, String question, List<AnswerOTM> answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}

}
