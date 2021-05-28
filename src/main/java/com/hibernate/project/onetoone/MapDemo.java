package com.hibernate.project.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");  //configuration file path
		SessionFactory factory = cfg.buildSessionFactory();
		
		//Creating question 1
		Question question1 = new Question();
		question1.setQuestionId(1001);
		question1.setQuestion("What is java?");
		
		//Creating answer 1
		Answer answer1 = new Answer();
		answer1.setAnswerId(2560);
		answer1.setAnswer("Java is object oriented programming language");
		answer1.setQuestion(question1);  // for bi-directional
		question1.setAnswer(answer1);
		
		
		
		//Creating question 2
		Question question2 = new Question();
		question2.setQuestionId(1024);
		question2 .setQuestion("What is collection framework?");
				
		//Creating answer 2
		Answer answer2 = new Answer();
		answer2.setAnswerId(6985);
		answer2.setAnswer("Collection is an API which works with group of objects");
		answer2.setQuestion(question2);  // for bi-directional		
		question2.setAnswer(answer2);
		
		//Session
		
		Session s = factory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		//save
		s.save(question1);
		s.save(answer1);
		
		s.save(question2);
		s.save(answer2);
		
		tx.commit();
		
		
		//Fetching......
		Question ques = (Question)s.get(Question.class, 1024);
		System.out.println(ques.getQuestion());
		System.out.println(ques.getAnswer().getAnswer());
		
		s.close();
		factory.close();
		
	}
}
