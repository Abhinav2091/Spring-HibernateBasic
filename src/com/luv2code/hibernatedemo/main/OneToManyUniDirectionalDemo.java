package com.luv2code.hibernatedemo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Course;
import com.luv2code.hibernatedemo.entity.Instructor;
import com.luv2code.hibernatedemo.entity.InstructorDetails;
import com.luv2code.hibernatedemo.entity.Review;

public class OneToManyUniDirectionalDemo {
	
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try 
		{   
			//add course and Reviews to table
			//addCourseAndReviews(session);
			//get course and Reviews to table
			//getReviews(session);
			//delete course and Reviews to table
			deletCourseAndReviews(session);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			session.close();
			
			factory.close();
		}

	}

	private static void deletCourseAndReviews(Session session) {
		//start a transaction
		session.beginTransaction();
		
		Course temCourse =session.get(Course.class, 13);

		//print the reviews
		System.out.println(temCourse.getReview());
		
		//delete the course
		session.delete(temCourse);
		
		//commit transaction
		session.getTransaction().commit();
		System.out.println("End!");
	}

	private static void getReviews(Session session) {
		//start a transaction
		session.beginTransaction();
		
		//create a course object
		//get the course by id
		Course temCourse = session.get(Course.class, 13);
		
		System.out.println(temCourse);
		
		//get the reviews
		System.out.println(temCourse.getReview());
		
		//commit transaction
		session.getTransaction().commit();
		System.out.println("End!");
	}

	private static void addCourseAndReviews(Session session) {
		//start a transaction
		session.beginTransaction();
		
		//create a course
		Course temCourse =new Course("pace man-- how to score more !");
		
		//add some review
		temCourse.addReview(new Review("review one"));
		temCourse.addReview(new Review("review two"));
		temCourse.addReview(new Review("review three"));
		
		//save the course .. and levrage cascade all
		System.out.println("saving course::");
		System.out.println(temCourse);
		System.out.println(temCourse.getReview());
		session.save(temCourse);
		
		//commit transaction
		session.getTransaction().commit();
		System.out.println("End!");
	}

}
