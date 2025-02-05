package com.state;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.factory.FactoryCls;
import com.tutorial.Certificate;
import com.tutorial.Student;

public class StateDemo {
	public static void main(String[] args) {
		//Hibernate Object states
		//Transient
		//Persistent
		//Detached 
		//Removed
		
		SessionFactory factory=FactoryCls.getFactory();
		
		//Creating student object
		Student st1=new Student();
		st1.setId(101);
		st1.setName("Warner");
		st1.setCity("Rome");
		st1.setCert(new Certificate("Java Cerificate","6 months"));
		//Student :Transient
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		s.persist(st1);
		//student: Persistent - object associated with session, database
		st1.setName("Ravi");
		
		tx.commit();
		
		s.close();
		//student : Detached: data removed from session but present in database.
		st1.setName("Sachin");
		
		System.out.println(st1);
		
		factory.close();
	
		/*
		 * Removed state :data removed from database but associated with session when we
		 * remove or call delete
		 */ 
	}
}
