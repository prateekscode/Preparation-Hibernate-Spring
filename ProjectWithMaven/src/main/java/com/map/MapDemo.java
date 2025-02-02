package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.factory.FactoryCls;

public class MapDemo {

	public static void main(String[] args) {
		SessionFactory factory=FactoryCls.getFactory();
		
		//creating question
		Question q1=new Question();
		q1.setQuestionId(11);
		q1.setQuestion("What is Java");
		
		//Creating answer
		Answer ans=new Answer();
		ans.setAnswerId(103);
		ans.setAnswer("Java is programming language.");
		ans.setQuestion(q1);
		q1.setAnswer(ans);
		
		Question q2=new Question();
		q2.setQuestionId(22);
		q2.setQuestion("What is collection framework");
		
		//Creating answer
		Answer ans1=new Answer();
		ans1.setAnswerId(101);
		ans1.setAnswer("API to work with objects in java.");
		ans1.setQuestion(q2);
		q2.setAnswer(ans1);
		
		//Session
		Session s=factory.openSession();
		Transaction tx = s.beginTransaction();
		
		s.persist(q1);
		s.persist(ans);
		s.persist(q2);
		s.persist(ans1);
		tx.commit();
		
		//fetching
		Question newque = s.get(Question.class, 11);
		System.out.println(newque.getQuestion());
		System.out.println(newque.getAnswer().getAnswer());
		
		s.close();
		factory.close();
	}

}
