package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.factory.FactoryCls;

public class MapDemoMTM {
	public static void main(String[] args) {
		SessionFactory factory=FactoryCls.getFactory();
		
		Emp e1=new Emp();
		e1.setEid(101);
		e1.setName("Ankush");
		
		Emp e2=new Emp();
		e2.setEid(102);
		e2.setName("Sam");
		
		
		Project p1=new Project();
		Project p2=new Project();
		p1.setPid(81);
		p1.setProjectName("SCM");
		
		p2.setPid(91);
		p2.setProjectName("Libraray Manag. Sys.");
		
		List<Emp> emplist=new ArrayList<Emp>();
		emplist.add(e1);
		emplist.add(e2);
		
		List<Project> prolist=new ArrayList<Project>();
		prolist.add(p1);
		prolist.add(p2);
		
		e1.setProjects(prolist);
		p2.setEmps(emplist);
		
		Session s=factory.openSession();
		
		Transaction tx=s.beginTransaction();
		
		s.persist(e1);
		s.persist(p1);
		s.persist(e2);
		s.persist(p2);
		
		tx.commit();
		
		factory.close();
		s.close();
	}
}
