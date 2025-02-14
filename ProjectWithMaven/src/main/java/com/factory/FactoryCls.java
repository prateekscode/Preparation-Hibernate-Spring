package com.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryCls {
	private static SessionFactory factory;

	private FactoryCls() {
	}

	static {
		try {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error while creating sessionFactory object");
		}
	}

	public static SessionFactory getFactory() {
		return factory;
	}
}
