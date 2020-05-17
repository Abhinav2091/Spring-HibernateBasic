package com.luv2code.hibernatedemo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Instructor;
import com.luv2code.hibernatedemo.entity.InstructorDetails;




public class OneToOneDemo {

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
			//add instructor with cascading
			addInstructor(session);
			
			//delete instructor with cascading
			
			//deleteInstructor(session);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}

	}

	private static void deleteInstructor(Session session) {
		//start a transaction
		session.beginTransaction();
		
		//get instructor by there primary key 
		int id =1;
		Instructor instructor = session.get(Instructor.class,id);
		System.out.println(instructor);
		
		//delete that id  will also delete cascade related
		if(instructor!=null)
			session .delete(instructor);
		
		
		//commit transaction
		session.getTransaction().commit();
		System.out.println("End!");
	}

	private static void addInstructor(Session session) {
		//create the objects
			Instructor instructor = new Instructor("Aju","Sharma","luv2codeaju.com");
			InstructorDetails instructorDetails = new InstructorDetails("youtubechannel ","Luv to code!"); 
			
			//associate the object
			instructor.setInstructorDetails(instructorDetails);
			
			
			//start a transaction
			session.beginTransaction();
			
			//save the object because of cascade it will save other object as well
			session.save(instructor);
			
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("End!");
	}

}

