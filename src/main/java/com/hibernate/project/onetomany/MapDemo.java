package com.hibernate.project.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sun.xml.txw2.output.TXWResult;

public class MapDemo {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");  //configuration file path
		SessionFactory factory = cfg.buildSessionFactory();
		
/*		//Creating question 1
		Question question1 = new Question();
		question1.setQuestionId(1001);
		question1.setQuestion("What is java?");
		
		//Creating answer 1
		Answer answer1 = new Answer();
		answer1.setAnswerId(2560);
		answer1.setAnswer("Java is object oriented programming language");
		answer1.setQuestion(question1);
		
		//Creating answer 1
		Answer answer2 = new Answer();
		answer2.setAnswerId(2561);
		answer2.setAnswer("Java is a high-level, class-based, object-oriented programming language.");
		answer2.setQuestion(question1);
		
		//Creating answer 1
		Answer answer3 = new Answer();
		answer3.setAnswerId(2562);
		answer3.setAnswer("Java have different types of frameworks.");
		answer3.setQuestion(question1);
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(answer1);
		list.add(answer2);
		list.add(answer3);
		
		question1.setAnswers(list); */
		
		
		
		//Session
		
		Session s = factory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		//save
//		s.save(question1);
//		
//		s.save(answer1);
//		s.save(answer2);
//		s.save(answer3);
		
		tx.commit();
		
		
		//Fetching question with all answers
		Question q = (Question)s.get(Question.class, 1001);
		System.out.println(q.getQuestion());
		
		for (Answer a : q.getAnswers()) {
			
			System.out.println(a.getAnswer());
			
		}
		
		
		s.close();
		factory.close();
		
	}
}
