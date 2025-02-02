package com.map;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class AnswerOTM {
	@Id
	@Column(name = "answer_id")
	private int answerId;
	private String answer;
	
	@ManyToOne
	private QuestionOTM question;

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	

	public QuestionOTM getQuestion() {
		return question;
	}

	public void setQuestion(QuestionOTM q1) {
		this.question = q1;
	}

	public AnswerOTM(int answerId, String answer) {
		super();
		this.answerId = answerId;
		this.answer = answer;
	}

	public AnswerOTM() {
		super();
		// TODO Auto-generated constructor stub
	}

}
