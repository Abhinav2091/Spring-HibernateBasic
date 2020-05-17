package com.luv2code.hibernatedemo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Course;
import com.luv2code.hibernatedemo.entity.Instructor;
import com.luv2code.hibernatedemo.entity.InstructorDetails;

public class EagerAndLazyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// eager fetch i.e will fetch all things related to instructor
			// it will run qurery with all joins in eager case
			// and only the detail i asked for in lazy
			eagerandLazyFetch(session);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();

			factory.close();
		}

	}

	private static void eagerandLazyFetch(Session session) {
		// start a transaction
		session.beginTransaction();

		// get the instructor from db
		Instructor instructor = session.get(Instructor.class, 2);

		System.out.println("Instructor::" + instructor);

		System.out.println("break between instructor and courses");
		// System.out.println("Instructor_details::"+instructor.getInstructorDetails());
		System.out.println("break between instructor and courses");
		// normal senierio
		// get the courses of instructor
		// System.out.println("Courses:"+instructor.getCourse());

		// commit transaction
		session.getTransaction().commit();

		// breaking senierio
		session.close();
		System.out.println("End!");
	}

}
