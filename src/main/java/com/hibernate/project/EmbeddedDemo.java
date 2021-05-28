package com.hibernate.project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddedDemo {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");  //configuration file path
		SessionFactory factory = cfg.buildSessionFactory();
		
		
		//First student
		Student student1 = new Student();
		student1.setId(4523);
		student1.setName("Joey");
		student1.setCity("Lucknow");
		
		Certificate certificate = new Certificate();
		certificate.setCourse("Android");
		certificate.setDuration("2 months");
		
		student1.setCertificate(certificate);
		
		
		//Second student
		Student student2 = new Student();
		student2.setId(4853);
		student2.setName("Chandler");
		student2.setCity("Meerut");
		
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Hibernate");
		certificate1.setDuration("1 month");		
		student2.setCertificate(certificate1);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//objects save
		session.save(student1);
		session.save(student2);
		tx.commit();
		
		session.close();
		factory.close();
		
	}
}
