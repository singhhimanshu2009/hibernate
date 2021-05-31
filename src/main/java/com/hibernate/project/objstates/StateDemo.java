package com.hibernate.project.objstates;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.project.Certificate;
import com.hibernate.project.Student;

public class StateDemo {

	public static void main(String[] args) {
		
		System.out.println("Java Application");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//Creating student object
		Student student = new Student();
		student.setId(5656);
		student.setName("New Name");
		student.setCity("My City");
		student.setCertificate(new Certificate("Java Hibernate", "2 Months"));
		//student : transient state
		//object is neither associated with session nor with database
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(student);
		//persistance state : associated with session object and database
		
		student.setName("Name changed");
		
		
		
		tx.commit();
		s.close();  // session closed
		
		//student detached
		student.setName("After session closed");
		System.out.println("Name after session closed = "+ student);
		
		
		factory.close();

	}

}
