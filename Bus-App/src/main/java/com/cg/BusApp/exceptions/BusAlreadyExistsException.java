package com.cg.BusApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Http Status at input time to confirm what the issue is
@ResponseStatus(code = HttpStatus.CONFLICT)
public class BusAlreadyExistsException extends RuntimeException{
	
	public BusAlreadyExistsException() {
		
	}
	
	public BusAlreadyExistsException(String message) {
		super(message);
	}

}
