package com.hibernate.project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started");
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");  //configuration file path
		SessionFactory factory = cfg.buildSessionFactory();  
		
		System.out.println(factory);		
		System.out.println(factory.isClosed());
		
		//Creating student class object
		Student student = new Student();
		student.setId(101);
		student.setName("Himanshu");
		student.setCity("Meerut");
		System.out.println("Printing student object "+ student);
		
		
		//Creating address class object
		Address ad = new Address();
		ad.setStreet("Street1");
		ad.setCity("Meerut");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(1452.3252);
		System.out.println("Printing address object "+ ad);
		
		//Reading image
		FileInputStream fis = new FileInputStream("src/main/java/Image.jpg");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);		
		
		
		
		Session session = factory.openSession(); //factory open new session
		
		
		Transaction tx =  session.beginTransaction();		
		session.save(student);	  //Save Student object using hibernate
		session.save(ad);         //Save Address object using hibernate
		//session.getTransaction().commit();
		//or		
		tx.commit();		
		session.close();
		
		System.out.println("DONE");
		

	}
}
