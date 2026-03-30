package com.employee.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException{
	@Autowired
	private String message;
	@Autowired
	private HttpStatus status;
	
	public ResourceNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		this.message=message;
		this.status=HttpStatus.NOT_FOUND;
	}
	
	
	public String getMessage() {
		return message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	
	
	
}
