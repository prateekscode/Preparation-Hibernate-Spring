package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.factory.FactoryCls;

public class MapDemoOTM {

	public static void main(String[] args) {
		SessionFactory factory = FactoryCls.getFactory();

		// creating question
//		QuestionOTM q1 = new QuestionOTM();
//		q1.setQuestionId(11);
//		q1.setQuestion("What is Java");
//
//		// Creating answer
//		AnswerOTM ans = new AnswerOTM();
//		ans.setAnswerId(103);
//		ans.setAnswer("Java is programming language.");
//		ans.setQuestion(q1);
//
//		AnswerOTM ans1 = new AnswerOTM();
//		ans1.setAnswerId(101);
//		ans1.setAnswer("With the help of java we can create softwares.");
//		ans1.setQuestion(q1);
//
//		AnswerOTM ans2 = new AnswerOTM();
//		ans2.setAnswerId(102);
//		ans2.setAnswer("Java have diff. type of frameworks.");
//		ans2.setQuestion(q1);
//		
//		List<AnswerOTM> list = new ArrayList<AnswerOTM>();
//		list.add(ans);
//		list.add(ans1);
//		list.add(ans2);
//		
//		q1.setAnswers(list);
//		
//		// Session
		Session s = factory.openSession();
//		Transaction tx = s.beginTransaction();
//
//		s.persist(q1);
//		s.persist(ans);
//		s.persist(ans1);
//		s.persist(ans2);
//		
//		tx.commit();

		// fetching
		QuestionOTM que = (QuestionOTM) s.get(QuestionOTM.class, 11);
		System.out.println(que.getQuestion());
		for (AnswerOTM a : que.getAnswers())
			System.out.println(a.getAnswer());

		s.close();
		factory.close();
	}

}
