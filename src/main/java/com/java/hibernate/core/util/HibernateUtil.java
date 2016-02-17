package com.java.hibernate.core.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernate.core.entity.Employee;
import com.java.hibernate.core.entity.User;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	public static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(User.class);
			return configuration.buildSessionFactory();
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

}
