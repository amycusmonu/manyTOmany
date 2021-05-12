package com.app.oneTOone.demo;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.app.oneTOone.demo.entity.Course;
import com.app.oneTOone.demo.entity.Instructor;
import com.app.oneTOone.demo.entity.InstructorDetail;
import com.app.oneTOone.demo.entity.Review;
import com.app.oneTOone.demo.entity.Student;

public class B2AddCourseForRamDemo {
	public static void main(String[] args) {

//create session  Factory	
		org.hibernate.SessionFactory sessionFactory = new

		Configuration().configure().addAnnotatedClass(Instructor.class).
		addAnnotatedClass(InstructorDetail.class).
		addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = sessionFactory.getCurrentSession();

		try {
		

			// start the transaction
			session.beginTransaction();
//get student JAY from DB
			Student tempStudent=session.get(Student.class, 8);
	System.out.println("lOaed student -"+tempStudent);		
	System.out.println("courses="+tempStudent.getCourses());			

	//create course
	Course tempCourse1=new Course("java");
	Course tempCourse2=new Course("cpp");
	
	//add student to course
	
	System.out.println("------------------we r going to addStudent meth----------------------");
	
	tempCourse1.addStudent(tempStudent);
	tempCourse2.addStudent(tempStudent);
	
	//save the courses
	session.save(tempCourse1);
session.save(tempCourse2);
	System.out.println(tempStudent.getCourses());
	System.out.println("-----------------------------------");
		// commit transaction
			session.getTransaction().commit();

			System.out.println("  -Done-");

		} catch (Exception e) {
			session.close();
			sessionFactory.close();
		}

	}
}
