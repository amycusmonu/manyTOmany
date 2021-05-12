package com.app.oneTOone.demo;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.app.oneTOone.demo.entity.Course;
import com.app.oneTOone.demo.entity.Instructor;
import com.app.oneTOone.demo.entity.InstructorDetail;
import com.app.oneTOone.demo.entity.Review;
import com.app.oneTOone.demo.entity.Student;

public class E5DeleteStudentDemo {
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
			
			Student temStudent=session.get(Student.class, 1);
			
			//delete c++ course from DB
			System.out.println("deleting =="+temStudent);
			System.out.println("------------------------------------------");
			
			System.out.println("------------------------------------------");
				
				session.delete(temStudent);
	
			
		// commit transaction
			session.getTransaction().commit();

			System.out.println("  -Done-");

		} catch (Exception e) {
			session.close();
			sessionFactory.close();
		}

	}
}
