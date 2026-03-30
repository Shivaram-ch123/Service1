package com.employee.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException{
	private String message;
	private HttpStatus status;
	
	public BadRequestException(String message) {
		this.message=message;
		status=HttpStatus.BAD_REQUEST;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getStatus() {
		return status;
	}
	
	
}
