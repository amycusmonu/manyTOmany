package com.app.oneTOone.demo;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.app.oneTOone.demo.entity.Course;
import com.app.oneTOone.demo.entity.Instructor;
import com.app.oneTOone.demo.entity.InstructorDetail;
import com.app.oneTOone.demo.entity.Review;
import com.app.oneTOone.demo.entity.Student;

public class CreateCoursesAndReviewsDemo {
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
			/*
			 * 
			 * // start the transaction session.beginTransaction();
			 * 
			 * //create course Course tempCourse=new Course("yoga course");
			 * 
			 * //add some reviews tempCourse.addReview(new Review("good course-!!!"));
			 * tempCourse.addReview(new Review("flexibilty course-!!!"));
			 * tempCourse.addReview(new Review("fitness increseing course-!!!"));
			 * 
			 * //save course and leaverage the cascade all
			 * System.out.println("\n saving the course");
			 * System.out.println("\ncourse="+tempCourse);
			 * System.out.println("\nreviews=="+tempCourse.getReviews());
			 * session.save(tempCourse);
			 * 
			 * // commit transaction session.getTransaction().commit();
			 * 
			 * System.out.println("  -Done-");
			 */



			// start the transaction
			session.beginTransaction();

			//create course 
			Course tempCourse=session.get(Course.class,31);
			
			//add some reviews
			tempCourse.addReview(new Review("body tonning course-!!!"));
			tempCourse.addReview(new Review("flexibilty course-!!!"));
			tempCourse.addReview(new Review("fitness increseing course-!!!"));
			
			//save course and leaverage the cascade all
			System.out.println("\n saving the course");
System.out.println("\ncourse="+tempCourse);
			System.out.println("\nreviews=="+tempCourse.getReviews());
			session.save(tempCourse);
			
			// commit transaction
			session.getTransaction().commit();

			System.out.println("  -Done-");
			
		} catch (Exception e) {
			session.close();
			sessionFactory.close();
		}

	}
}
