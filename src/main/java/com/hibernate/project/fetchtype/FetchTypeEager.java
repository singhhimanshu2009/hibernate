package com.hibernate.project.fetchtype;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.project.onetomany.Question;

public class FetchTypeEager {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session s = factory.openSession();
		
		Question q = (Question)s.get(Question.class, 1001);
		
		//Add FetchType.Eager in Question entity for eager loading (OneToMany)
		System.out.println(q.getQuestionId());
		System.out.println(q.getQuestion());
		
		//Query will not run again
		System.out.println(q.getAnswers().size());
		
		
		factory.close();
		
	}

}
