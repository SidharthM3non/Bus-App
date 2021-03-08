package com.cg.BusApp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//Entity Creation with annotation
@Entity
public class BusRoute {
	
	//Primary key field
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	//fields (or) columns
	String routeName;
	String source;
	String destination;
	
	//Unidirectional mapping to Bus table
	@ManyToOne(cascade = CascadeType.ALL)
	Bus bus;
	
	//Non-parameterized constructor
	public BusRoute() {
		
	}
	
	//Parameterized constructor
	public BusRoute(String routeName, String source, String destination, Bus bus) {
		super();
		this.routeName = routeName;
		this.source = source;
		this.destination = destination;
		this.bus = bus;
	}

	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}
	
	
}
