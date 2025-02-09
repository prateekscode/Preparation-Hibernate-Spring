package com.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.SelectionQuery;

import com.factory.FactoryCls;
import com.tutorial.Student;

public class SqlEx {
	public static void main(String[] args) {
		SessionFactory factory=FactoryCls.getFactory();
		Session s=factory.openSession();
		
		String q="select * from student";
		
		NativeQuery query = s.createNativeQuery(q);
		List<Object[]> list = query.list();
		list.forEach(l->System.out.println(l[4]+": "+l[3]));
	
		s.close();
		factory.close();
	}
}
