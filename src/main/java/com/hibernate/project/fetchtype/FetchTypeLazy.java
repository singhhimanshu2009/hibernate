package com.hibernate.project.fetchtype;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.project.onetomany.Question;

public class FetchTypeLazy {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session s = factory.openSession();
		
		//Lazy Loading (OneToMany)
		//Answer queries will not be fired by default
		Question q = (Question)s.get(Question.class, 1001);
		System.out.println(q.getQuestionId());
		System.out.println(q.getQuestion());
		
		//Data loads when we call size()
		System.out.println(q.getAnswers().size());
		
		factory.close();

	}

}
