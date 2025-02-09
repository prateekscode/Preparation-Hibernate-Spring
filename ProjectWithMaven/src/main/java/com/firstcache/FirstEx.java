package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.factory.FactoryCls;
import com.tutorial.Student;

public class FirstEx {
	public static void main(String[] args) {
		SessionFactory factory = FactoryCls.getFactory();
		Session s = factory.openSession();
		
		//by default enabled
		Student st = s.get(Student.class, 558);
		System.out.println(st);
		System.out.println("Doing another work");
		
		Student st1 = s.get(Student.class, 558);
		System.out.println(st1);
		
		//to check any object in session cache
		System.out.println(s.contains(st1));
		
		s.close();
		factory.close();
	}
}
