package com.app.oneTOone.demo;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.app.oneTOone.demo.entity.Course;
import com.app.oneTOone.demo.entity.Instructor;
import com.app.oneTOone.demo.entity.InstructorDetail;
import com.app.oneTOone.demo.entity.Review;
import com.app.oneTOone.demo.entity.Student;

public class A1CreateCoursesAndStudentDemo {
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

			//create course 
			Course tempCourse=new Course("kumfu course");
			
			//save course 
			session.save(tempCourse);
			System.out.println("saved course-"+tempCourse);
			//create student
			Student tempStudent1=new Student("CM", "kale", "amu11@gmail.com");
			Student tempStudent2=new Student("jay", "ramana", "omram@gmail.com");
			
			//add student to course
		//	System.out.println("\n from here go to addStudent method");
			
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			//saving student
			session.save(tempStudent1);
			session.save(tempStudent2);
			
	System.out.println("saved course=="+tempCourse.getStudents());
			
		// commit transaction
			session.getTransaction().commit();

			System.out.println("  -Done-");

		} catch (Exception e) {
			session.close();
			sessionFactory.close();
		}

	}
}
