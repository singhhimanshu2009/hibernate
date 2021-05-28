package com.hibernate.project.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.sun.beans.introspect.PropertyInfo.Name;

@Entity
public class Employee {
	
	@Id
	private int eId;
	private String eName;
	
	@ManyToMany
	@JoinTable
	(
			name = "emp_project", // to change name of table
			joinColumns = {@JoinColumn(name="eId")},     // to change name of join column
			inverseJoinColumns = {@JoinColumn(name="pId")}  // to change name of inverse join column
	)
	private List<Project> projects;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int eId, String eName, List<Project> projects) {
		super();
		this.eId = eId;
		this.eName = eName;
		this.projects = projects;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", projects=" + projects + "]";
	}	
	

}
