package com.luv2code.hibernatedemo.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Student;


public class GetSessionFactory {
	

	public Session getSession() {
		// create a session factory
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.hml")
				.addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session =sessionFactory.getCurrentSession();
		return session;

	}
}
