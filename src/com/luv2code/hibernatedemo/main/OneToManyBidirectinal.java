package com.luv2code.hibernatedemo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Course;
import com.luv2code.hibernatedemo.entity.Instructor;
import com.luv2code.hibernatedemo.entity.InstructorDetails;

public class OneToManyBidirectinal {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// add course for particulat id
			// addCourse(session);
			
			//fetch course
			//fetchCourse(session);
			
			//delet course
			deleteCourse(session);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

	private static void deleteCourse(Session session) {
		//start a transaction
		session.beginTransaction();
		
		//get the course from db
		Course course = session.get(Course.class, 10);
		
		//delete the course
		session.delete(course);
		
		//commit transaction
		session.getTransaction().commit();
		System.out.println("End!");
	}

	private static void fetchCourse(Session session) {
		// start a transaction
		session.beginTransaction();

		// get the instructor from db
		Instructor instructor = session.get(Instructor.class, 2);

		System.out.println(instructor);

		// get the courses of instructor
		System.out.println("Courses:" + instructor.getCourse());

		// commit transaction
		session.getTransaction().commit();
		System.out.println("End!");
	}

	private static void addCourse(Session session) {
		// start a transaction
		session.beginTransaction();

		// get the instructor from db
		Instructor instructor = session.get(Instructor.class, 2);

		// create the course
		Course course1 = new Course("Course one");
		Course course2 = new Course("Course two");
		Course course3 = new Course("Course three");

		// add those courses
		instructor.add(course1);
		instructor.add(course2);
		instructor.add(course3);

		// save those courses

		// save the object cos of cascade it will save other object as well
		session.save(course1);
		session.save(course2);
		session.save(course3);

		// commit transaction
		session.getTransaction().commit();
		System.out.println("End!");
	}

}
