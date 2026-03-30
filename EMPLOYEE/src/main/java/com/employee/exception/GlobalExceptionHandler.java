package com.employee.exception;


import com.employee.exception.*;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
		ErrorResponse response = new ErrorResponse(ex.getMessage(),ex.getStatus());
		return new ResponseEntity<>(response,ex.getStatus());
	}
	
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponse> handlerBadRequestException(BadRequestException ex){
		ErrorResponse response = new ErrorResponse(ex.getMessage(),ex.getStatus());
		return new ResponseEntity<>(response,ex.getStatus());
	}
	
	
	@ExceptionHandler(MissingParameterException.class)
	public ResponseEntity<ErrorResponse> handlerMissingParameterException(MissingParameterException ex){
		ErrorResponse response = new ErrorResponse(ex.getMessage(),ex.getStatus());
		return new ResponseEntity<>(response,ex.getStatus());
	}
}
