package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.SelectionQuery;

import com.factory.FactoryCls;
import com.tutorial.Student;

public class HQLPagination {

	public static void main(String[] args) {
		SessionFactory factory=FactoryCls.getFactory();
		Session s = factory.openSession();
		SelectionQuery<Student> query = s.createSelectionQuery("from Student", Student.class);
		
		//implementing pagination using hibernate 
		
		query.setFirstResult(11);
		query.setMaxResults(5);
		
		List<Student> list = query.list();
		list.forEach(x->System.out.println(x.getId()+": "+x.getName()+": "+x.getCity()));
		
		s.close();
		factory.close();
	}

}
