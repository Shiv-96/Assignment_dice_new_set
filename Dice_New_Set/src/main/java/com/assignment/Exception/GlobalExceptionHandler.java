package com.assignment.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<Error> userExceptionHandler(UserException ue, WebRequest we) {
		
		Error er = new Error(LocalDateTime.now(), ue.getMessage(), we.getDescription(false));
		
		return new ResponseEntity<Error>(er, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error> anyExceptionHandler(Exception ue, WebRequest we) {
		
		Error er = new Error(LocalDateTime.now(), ue.getMessage(), we.getDescription(false));
		
		return new ResponseEntity<Error>(er, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<Error> noHandlerFoundExceptionHandler(NoHandlerFoundException ue, WebRequest we) {
		
		Error er = new Error(LocalDateTime.now(), ue.getMessage(), we.getDescription(false));
		
		return new ResponseEntity<Error>(er, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Error> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ue, WebRequest we) {
		
		Error er = new Error(LocalDateTime.now(), ue.getMessage(), we.getDescription(false));
		
		return new ResponseEntity<Error>(er, HttpStatus.BAD_REQUEST);
		
	}
	
	
}
