package com.cg.BusApp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

//Entity Creation with annotation
@Entity
public class Feedback {

	//Primary key field
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	//fields (or) columns
	int rating;
	String comment;
	String username;
	String routeName;
	
	//Unidirectional mapping to Bus Operator table
	@OneToOne(cascade = CascadeType.ALL)
	BusOperator busOperator;
	
	@ManyToOne(cascade = CascadeType.ALL)
	User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	BusRoute busRoute;
	
	//Non-parameterized constructor
	public Feedback() {
		
	}
	
	//Parameterized constructor
	public Feedback(int rating, String comment, String username, String routeName, BusOperator busOperator) {
		super();
		this.rating = rating;
		this.comment = comment;
		this.username = username;
		this.routeName = routeName;
		this.busOperator = busOperator;
	}

	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public BusOperator getBusOperator() {
		return busOperator;
	}

	public void setBusOperator(BusOperator busOperator) {
		this.busOperator = busOperator;
	}
	
	
	
}
