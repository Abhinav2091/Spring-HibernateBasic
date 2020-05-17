package com.luv2code.hibernatedemo.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernatedemo.entity.Course;
import com.luv2code.hibernatedemo.entity.Instructor;
import com.luv2code.hibernatedemo.entity.InstructorDetails;
import com.luv2code.hibernatedemo.entity.Review;
import com.luv2code.hibernatedemo.entity.Student;




public class ManyToManyDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try 
		{   
			//create student and ccourse
			//createCourseandStudent(session);
			
			//add more course to id 6
			//addMoreCourseForParticularStudent(session);
			
			
		  
			//get courses for a student
			//getCourses(session);
			
			//delete course on basis of id
			//deleteCourse(session);
			
			//delete Student
			deleteStudent(session);
			
			
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

	private static void deleteStudent(Session session) {
		//start a transaction
		session.beginTransaction();
  
		//get student marry from db
		Student theStudent = session.get(Student.class, 6);
		System.out.println("loaded Student::"+theStudent);
		System.out.println("corse associated:"+theStudent.getCourses());
		
		///delete marry fromm student 
		session.delete(theStudent);
		
		
		//commit transaction
		session.getTransaction().commit();
		System.out.println("End!");
	}

	private static void deleteCourse(Session session) {
		//start a transaction
		session.beginTransaction();
  
		//get student marry from db
		Student theStudent = session.get(Student.class, 6);
		System.out.println("loaded Student::"+theStudent);
		System.out.println("curse associated:"+theStudent.getCourses());
		
		//get the packman cousre and delte it
		Course theCourse =session.get(Course.class, 14);
		
		//delete the course
		session.delete(theCourse);
		
		System.out.println("deleteing the course");
		
		//commit transaction
		session.getTransaction().commit();
		System.out.println("End!");
	}

	private static void getCourses(Session session) {
		//start a transaction
		session.beginTransaction();
		//get student marry from db
		Student theStudent = session.get(Student.class, 6);
		System.out.println("loaded Student::"+theStudent);
		System.out.println("curse associated:"+theStudent.getCourses());
		
		
		//commit transaction
		session.getTransaction().commit();
		System.out.println("End!");
	}

	private static void addMoreCourseForParticularStudent(Session session) {
		//start a transaction
		session.beginTransaction();
  
		//get student marry from db
		Student theStudent = session.get(Student.class, 6);
		System.out.println("loaded Student::"+theStudent);
		System.out.println("curse associated:"+theStudent.getCourses());
		
		//create course for marry
		Course theCourse = new Course("Spring course");
		Course theCourse1 = new Course("Hibernate");
		
		//add  student to Courses
		theCourse.addStudent(theStudent);
		theCourse1.addStudent(theStudent);
		
		System.out.println("Saving the course::");
		
		//save the courses
		session.save(theCourse);
		session.save(theCourse1);
		
		
		
		//commit transaction
		session.getTransaction().commit();
		System.out.println("End!");
	}

	private static void createCourseandStudent(Session session) {
		//start a transaction
		session.beginTransaction();
		
		//create a course
		Course temCourse =new Course("pace man-- how to score more new !");
		
		
		
		//save the course .. and levrage cascade all
		System.out.println("saving course::");
		System.out.println(temCourse);
		
		session.save(temCourse);
		
		//create the Student
		Student tempStudent= new Student("John","Done","john@gmail.com");
		Student tempStudent1= new Student("mary","jain","mary@gmail.com");
		
		//add student to the course
		temCourse.addStudent(tempStudent);
		temCourse.addStudent(tempStudent1);
		
		//save the student
		session.save(tempStudent);
		session.save(tempStudent1);
		System.out.println("Saved the student:");
		
		//commit transaction
		session.getTransaction().commit();
		System.out.println("End!");
	}

}
