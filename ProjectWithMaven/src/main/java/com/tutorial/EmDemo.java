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
		
		Student stu3=new Student();
		stu3.setId(333);
		stu3.setName("Rahul");
		stu3.setCity("Mumbai");
		Certificate certificate3=new Certificate();
		certificate3.setCourse("Android");
		certificate3.setDuration("2.5 months");
		stu3.setCert(certificate3);
		
		Student stu4=new Student();
		stu4.setId(444);
		stu4.setName("Kamal");
		stu4.setCity("Lucknow");
		Certificate certificate4=new Certificate();
		certificate4.setCourse("ReactJS");
		certificate4.setDuration("3 months");
		stu4.setCert(certificate4);
		
		
		Session s=factory.openSession();
		Transaction tx = s.beginTransaction();
		//Objects saving
//		s.persist(stu1);
//		s.persist(stu2);
//		s.persist(stu3);
//		s.persist(stu4);
//		
//		tx.commit();
//		s.close();
		factory.close();
	}

}
