package com.hibernate.project.pagination;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.project.Student;

public class Pagination {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Query<Student> query = session.createQuery("from Student");
		
		//pagination using hibernate
		query.setFirstResult(0);
		
		query.setMaxResults(1);
		
		List<Student> list = query.list();
		
		for (Student st : list) {
			
			System.out.println(st.getId() +" " +st.getName()+" "+ st.getCertificate()+ " "+ st.getCity());
			
		}
		
		
		
		
		session.close();
		factory.close();

	}

}
