package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.factory.FactoryCls;
import com.map.AnswerOTM;
import com.map.QuestionOTM;

public class CascadingEx {

	public static void main(String[] args) {
		SessionFactory factory = FactoryCls.getFactory();
		Session s = factory.openSession();

		QuestionOTM q1 = new QuestionOTM();
		q1.setQuestionId(000);
		q1.setQuestion("What is cascading...?");

		AnswerOTM a1 = new AnswerOTM(000, "It is imp concept in hibernate");
		AnswerOTM a2 = new AnswerOTM(11, "2nd Answer");
		AnswerOTM a3 = new AnswerOTM(22, "3rd Answer");

		List<AnswerOTM> list = new ArrayList<AnswerOTM>();
		list.add(a1);
		list.add(a2);
		list.add(a3);

		q1.setAnswers(list);

		Transaction tx = s.beginTransaction();
		s.persist(q1);

		/*
		 * if we don't use cascade so we have persist all answers individually like
		 * below----
		 */
//		s.persist(a1);
//		s.persist(a2);
//		s.persist(a3);

		// to get rid of this we make the entity cascade so all of its related
		// entities will updated.

		// for this program we are going to use cascade in QuestionOTM so,
//		the related answers will also reflected in the database table. 

		tx.commit();

		s.close();
		factory.close();
	}

}
