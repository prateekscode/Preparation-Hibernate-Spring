package com.HQL;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.SelectionQuery;

import com.factory.FactoryCls;
import com.tutorial.Student;
	
public class HQLExample {
	public static void main(String[] args) {
		SessionFactory factory = FactoryCls.getFactory();

		Session s = factory.openSession();
		// HQL
		// Syntax:
//		String query="from Student where city='Lucknow'";
//		String query="from Student where city=:x";
		String query = "from Student as s where s.city=:x and s.name=:y";

		SelectionQuery q = s.createSelectionQuery(query);

		q.setParameter("x", "Lucknow");
		q.setParameter("y", "Anik");

		// single - (Unique)
		// multiple - list
		List<Student> list = q.list();
		list.forEach(l -> System.out.println(l.getName() + " " + l.getCert().getCourse()));

		System.out.println("----------");

		Transaction tx = s.beginTransaction();

		// Delete query

//		MutationQuery query2= s.createMutationQuery("delete from Student as s where s.city=:c");
//		query2.setParameter("c", "kolkata");
//		int r=query2.executeUpdate();
//		System.out.println("Deleted");
//		System.out.println(r);

		// Update query

		MutationQuery q3= s.createMutationQuery("update Student set set city=:c where name =:n");
		q3.setParameter("c", "Dehradun");
		q3.setParameter("n", "Kamal");
		int r2 = q3.executeUpdate();
		System.out.println(r2 + " Objects updated");

		// execute join query

		SelectionQuery q4 = s.createSelectionQuery("select q.question, q.questionId, a.answer from QuestionOTM as q INNER JOIN q.answers as a");
		List<Object[]> list2 = q4.getResultList();
		
		for(Object[] arr:list2) {
			System.out.println(Arrays.toString(arr));
		}
		
		tx.commit();

		s.close();
		factory.close();
	}
}
