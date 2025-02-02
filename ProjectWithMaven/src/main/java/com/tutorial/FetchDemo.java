package com.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.factory.FactoryCls;

public class FetchDemo {

	public static void main(String[] args) {
		// get , load
		SessionFactory factory=FactoryCls.getFactory();
		Session session=factory.openSession();
		//We need Transaction only when we have save data for getting data we don't need.
		
		//get
		//--we can also use load in place of get
		
		//get return null if object not found while load throws ObjectNotFoundException
		/*
		 * get() hits the database only first time or if data is not available in
		 * session cache(if session was cleared) if data is available in session cache
		 * then it will not hit database again it picks the data from session cache.
		*/
		
		/*
		 * load() uses lazy initialization it makes proxy object do not return actual
		 * object until the object is not used like we not use obj.getStreet(); if we 
		 * call any method than it will call actual object  
		 */
		Student student=(Student)session.get(Student.class, 101);
		System.out.println(student);
		
		Student student1=(Student)session.get(Student.class, 101);
		System.out.println(student1);
		
		Address address=(Address)session.load(Address.class, 3);
		System.out.println(address.getStreet()+" "+address.getCity());
		
		
		session.close();
		factory.close();
	}

}
