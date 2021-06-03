package com.hibernate.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.project.Student;

public class HqlDemo {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		String query = "from Student where course =:x";
		String query1 = "from Student where course = 'Lucknow'";
		String query2 = "from Student as s where s.name=:n and s.city = :x";
		
		Query q = session.createQuery(query2);
		q.setParameter("n", "Chandler");
		q.setParameter("x", "Meerut");
		
		//for multiple result
		List<Student> list = q.list();
		
		for (Student student : list) {
			
			System.out.println(student.getName() + ":"+ student.getCertificate().getCourse());
			
		}
		
		
		//for single result
		
		
		
		session.close();
		factory.close();
		
	}

}
