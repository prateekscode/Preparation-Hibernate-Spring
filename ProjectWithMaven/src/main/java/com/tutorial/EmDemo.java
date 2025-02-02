package com.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.factory.FactoryCls;

public class EmDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=FactoryCls.getFactory();
		Student stu1=new Student();
		stu1.setId(111);
		stu1.setName("Anik");
		stu1.setCity("Lucknow");
		Certificate certificate=new Certificate();
		certificate.setCourse("Kotlin");
		certificate.setDuration("2 months");
		stu1.setCert(certificate);
		
		Student stu2=new Student();
		stu2.setId(222);
		stu2.setName("Ravi");
		stu2.setCity("Kolkata");
		Certificate certificate2=new Certificate();
		certificate2.setCourse("Android");
		certificate2.setDuration("3 months");
		stu2.setCert(certificate2);
		
		Session s=factory.openSession();
		Transaction tx = s.beginTransaction();
		//Objects saving
		s.persist(stu1);
		s.persist(stu2);
		
		tx.commit();
		s.close();
		factory.close();
	}

}
