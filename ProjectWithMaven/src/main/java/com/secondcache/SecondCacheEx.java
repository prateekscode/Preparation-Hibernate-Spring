package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.factory.FactoryCls;
import com.tutorial.Student;

public class SecondCacheEx {

	public static void main(String[] args) {
		SessionFactory factory = FactoryCls.getFactory();
		Session s1 = factory.openSession();

		//first
		Student st1 = s1.get(Student.class, 444);
		System.out.println(st1);
		s1.close();
		
		Session s2 = factory.openSession();
		//second
		Student st2 = s2.get(Student.class, 444);
		System.out.println(st2);
		s2.close();
		factory.close();
	}

}
