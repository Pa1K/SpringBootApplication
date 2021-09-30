package com.pavan.restapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

@Entity
@Component("addr1")
public class Address {
	
	@Id
	@SequenceGenerator(name="mysequence", initialValue=7)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mysequence")
	private Long pincode;
	private String place;
	private String state;
	
	public Address() {
		super();
		System.out.println("Address object created...");
	}
	
	public Address(String place, String state, Long pincode) {
		super();
		this.place = place;
		this.state = state;
		this.pincode = pincode;
	}
	
	

	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getPincode() {
		return pincode;
	}
	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
			
	public void display() {
		System.out.println("display method in Address.java");
	}

}
