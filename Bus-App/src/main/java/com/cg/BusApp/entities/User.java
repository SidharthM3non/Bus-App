package com.cg.BusApp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Entity Creation with annotation
@Entity
@Table(name = "Users") //Postgre does not allow a table with name User; hence use this annotation
public class User {

	//Primary key field
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	//fields (or) columns
	String username;
	String password;
	
//	//Unidirectional mapping to Feedback table
//	@OneToOne(cascade = CascadeType.PERSIST)
//	Feedback feedback;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Booking booking;

	//Non-parameterized constructor
	public User() {
		
	}
	
	//Parameterized constructor
	public User(String username, String password, Booking booking) {
		super();
		this.username = username;
		this.password = password;
		//this.feedback = feedback;
		this.booking = booking;
	}

	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

//	public Feedback getFeedback() {
//		return feedback;
//	}
//
//	public void setFeedback(Feedback feedback) {
//		this.feedback = feedback;
//	}
	
	
	
}
