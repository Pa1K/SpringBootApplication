package com.pavan.restapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Employee {
	
	@Id
	private int id;
	private String name;
	private String tech;
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", tech=" + tech + "]";
	}
	public Employee() {
		System.out.println("employee object created");
	}
	public Employee(int id, String name, String tech) {
		this.id = id;
		this.name = name;
		this.tech = tech;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}

	public void display() {
		System.out.println("Employee display method");
		
	}
	

}
