package com.kumsal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumsal.demo.entity.Instructor;
import com.kumsal.demo.entity.InstructorDetail;
import com.kumsal.demo.entity.Student;

public class DeleteInstructorDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();
		
		Session session=sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		try {
			int theId=6;
			InstructorDetail theTest=session.get(InstructorDetail.class, theId);
			
			System.out.println("the insructor detail "+theTest);
			
			System.out.println("the instructor "+theTest.getTheInstructor());
			theTest.getTheInstructor().setInstructorDetail(null);
			session.delete(theTest);
			session.getTransaction().commit();
			session.close();
			System.out.println("Deleted succesfuly");
		} finally {
			// TODO: handle finally clause
		}

	}

}
