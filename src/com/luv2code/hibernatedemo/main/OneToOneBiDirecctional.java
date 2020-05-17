package com.luv2code.hibernatedemo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Instructor;
import com.luv2code.hibernatedemo.entity.InstructorDetails;




public class OneToOneBiDirecctional {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try 
		{  
			//fetch instructor and its detail on basis of instructor details
			//fetchInstructor(session);
			
			//delet the instructor detail
			deleteInstructorDetail(session);
			
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

	private static void deleteInstructorDetail(Session session) {
		//start a transaction
		session.beginTransaction();
		
		//get the instructor Details
		int id=3;
		InstructorDetails instructorDetails = session.get(InstructorDetails.class, id);
		
		//print the instructor details
		System.out.println(instructorDetails);
		
		//print the accociated details
		System.out.println(instructorDetails.getInstructor());
		
		//remove the associated object
		//break bi-directional link
		instructorDetails.getInstructor().setInstructorDetails(null);
		
		//delete the instructor details
		session.delete(instructorDetails);
		//commit transaction
		session.getTransaction().commit();
		System.out.println("End!");
	}

	private static void fetchInstructor(Session session) {
		//start a transaction
		session.beginTransaction();
		
		//get the instructor Details
		int id=2;
		InstructorDetails instructorDetails = session.get(InstructorDetails.class, id);
		
		//print the instructor details
		System.out.println(instructorDetails);
		
		//print the accociated details
		System.out.println(instructorDetails.getInstructor());
		
		//commit transaction
		session.getTransaction().commit();
		System.out.println("End!");
	}

}

