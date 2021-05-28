package com.hibernate.project.manytomany;

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
		
		//creating employees		
		Employee emp1 = new Employee();
		emp1.seteId(101);
		emp1.seteName("Rajan");
		
		Employee emp2 = new Employee();		
		emp2.seteId(36);
		emp2.seteName("John");
		
		
		//Creating projects
		Project p1 = new Project();
		p1.setpId(501);
		p1.setpName("Library Managment System");
		
		Project p2 = new Project();		
		p2.setpId(696);
		p2.setpName("ChatBot");
		
		
		//Add employees to list
		List<Employee> listEmp = new ArrayList<Employee>();
		listEmp.add(emp1);
		listEmp.add(emp2);
		
		//Add projects to list
		List<Project> listPro = new ArrayList<Project>();		
		listPro.add(p1);
		listPro.add(p2);
		
		
		
		//Assign projects to employees
		emp1.setProjects(listPro);
		p2.setEmployees(listEmp);		

		
		
		//Session		
		Session s = factory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		s.save(emp1);
		s.save(emp2);
		s.save(p1);
		s.save(p2);
		
		tx.commit();
		
				
		
		s.close();
		factory.close();
		
	}
}
