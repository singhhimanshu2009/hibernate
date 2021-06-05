package com.hibernate.project.hql;

import java.util.Arrays;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQLQueries {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//Delete Query
		
//		String query = "delete from Student as s where s.name=:n";
		
		
		//Saved data from from embedded class
		
		
//		Query q = session.createQuery(query);
//		q.setParameter("n", "Chandler");
//		
//		int r = q.executeUpdate();
//		System.out.println(r);
		
		
		/******************************************************************************************************/
		
		
		//Update Query
		
		/*
		 * String query = "update Student set city=:c where name=:n";
		 * 
		 * Query queryDel = session.createQuery(query); queryDel.setParameter("n",
		 * "Joey"); queryDel.setParameter("c", "Delhi");
		 * 
		 * int r = queryDel.executeUpdate();
		 * 
		 * System.out.println(r);
		 */
		
		/*******************************************************************************************************/
		
		//Join Query
		
		Query q = session.createQuery(
				"select q.question, q.questionId, a.answer from com.hibernate.project.onetomany.Question as q INNER JOIN q.answers as a");

		List<Object[]> list = q.getResultList();

		for (Object[] ques : list) {

			System.out.println(Arrays.toString(ques));

		}
		
		
		/*******************************************************************************************************/
		
		tx.commit();		
		session.close();
		factory.close();

	}

}
