package com.cg.BusApp.exceptions;

public class UserNotFoundException extends RuntimeException{
	
	public UserNotFoundException(String message) {
		super(message);
	}
	
	public UserNotFoundException() {
		
	}

}
