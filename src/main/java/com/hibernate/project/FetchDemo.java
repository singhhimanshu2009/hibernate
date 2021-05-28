package com.hibernate.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		//Get-student:101
		Student stu101 = (Student)session.get(Student.class, 101);	
		System.out.println("Student 101 details : "+ stu101);
		
		//Get-student:102
		Student stu102 = (Student)session.load(Student.class, 102);	
		System.out.println("Student 101 details : "+ stu102);
		
		session.close();
		factory.close();
		
	}

}
