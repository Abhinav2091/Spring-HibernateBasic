package com.luv2code.hibernatedemo.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Student;

public class CrudStudentDemo {
	

	public static void main(String ar[])
	{
		// create a session factory
				SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class).buildSessionFactory();
				
				//create session
				Session session =sessionFactory.getCurrentSession();
				
	try
	{
		//create Student objcet and save
		//addStudentObject(session);
		
		//read stdent object
		//readStudentObject(sessionFactory);
		
		//HQL query
		//hqlQuery(session);
		
		//update Student Object
		//updateStudent(sessionFactory, session);
		
		//delete Student
		//deleteStudent(sessionFactory, session);
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		sessionFactory.close();	
	}
	
	}

	private static void deleteStudent(SessionFactory sessionFactory, Session session) {
		int studendentId = 3;
		
		//start a transaction
		session.beginTransaction();
		
		//commit transaction
		session.getTransaction().commit();
		
		//get a new session
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		//retrive student on basis of primary key
		Student mystudent = session.get(Student.class,studendentId);
		System.out.println("complete value");
		System.out.println(mystudent);
		
		//delete id 1
		System.out.println("Deleting the object");
		session.delete(mystudent);
		
		//delete student Id 2
		session.createQuery("delete from Student where id=2").executeUpdate();
		
		//commit the transation
		session.getTransaction().commit();
		

		System.out.println("End!");
	}

	private static void updateStudent(SessionFactory sessionFactory, Session session) {
		int studendentId = 1;
		
		//start a transaction
		session.beginTransaction();
		
		//commit transaction
		session.getTransaction().commit();
		
		//get a new session
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		//retrive student on basis of primary key
		Student mystudent = session.get(Student.class,studendentId);
		System.out.println("complete value");
		System.out.println(mystudent);
		System.out.println("Updating student  ");
		mystudent.setFirstName("Scooby");
		
		//commit the transation
		session.getTransaction().commit();
		
		session = sessionFactory.getCurrentSession();
	    session.beginTransaction();
		//New code to update all email ID
		System.out.println("Update all Student!");
		session.createQuery("update Student set email='Sccoby@gmail.com'").executeUpdate();
		//commite this transasstion
		session.getTransaction().commit();
		System.out.println("End!");
	}

	private static void hqlQuery(Session session) {
		//start a transaction
		session.beginTransaction();
		
	    //query student
		List<Student> theStudent = session.createQuery("from Student").getResultList();
		//query with condition
		List<Student> theStudent1 = session.createQuery("from Student where lastName='sharma'").getResultList();
		
		//display the student
		displayQueryObject(theStudent1);
		
		//commit transaction
		session.getTransaction().commit();
		System.out.println("End");
	}
	
	private static void displayQueryObject(List<Student> theStudent1) {
		for(Student student : theStudent1)
		{
			System.out.println(student);
		}
	}

	private static void readStudentObject(SessionFactory sessionFactory) {
		
		//get a new session
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		//retrive student on basis of primary key
		Student mystudent = session.get(Student.class,1);
		System.out.println("complete value");
		System.out.println(mystudent);
		
		
		//commit the transation
		session.getTransaction().commit();
		
		System.out.println("End");
	}

	private static void addStudentObject(Session session) {
		//create student object
		System.out.println("creating a student object");
		Student thestudent = new Student("Abhinav","Sharma","abc@gmail.com");
		Student thestudent1 = new Student("2","Sharma","1abc@gmail.com");
		Student thestudent2 = new Student("3","Sharma","2abc@gmail.com");
		Student thestudent3 = new Student("4","Sharma","3abc@gmail.com");
		
		//start a transaction
		session.beginTransaction();
		
		//save the student object
		System.out.println("Saving the student object");
		session.save(thestudent);
		session.save(thestudent1);
		session.save(thestudent2);
		session.save(thestudent3);
		
		//commit transaction
		session.getTransaction().commit();
		System.out.println("End");
	}
}
