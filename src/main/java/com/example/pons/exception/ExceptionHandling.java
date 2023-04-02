package com.example.pons.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class ExceptionHandling {

	@ExceptionHandler(NoAttendeeException.class)
	public ResponseEntity<?> noAttendeeExceptionHandler(NoAttendeeException exception, WebRequest request){
		ErrorDetails errorDetails=new ErrorDetails(exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoIplEventException.class)
	public ResponseEntity<?> noIplEventExceptionHandler(NoIplEventException exception, WebRequest request){
		ErrorDetails errorDetails=new ErrorDetails(exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IplMatchExistException.class)
	public ResponseEntity<?> iplMatchExistsExceptionHandler(IplMatchExistException exception, WebRequest request){
		ErrorDetails errorDetails=new ErrorDetails(exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(ExistingUserException.class)
	public ResponseEntity<?> iplMatchExistsExceptionHandler(ExistingUserException exception, WebRequest request){
		ErrorDetails errorDetails=new ErrorDetails(exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> ExceptionHandler(Exception exception, WebRequest request){
		ErrorDetails errorDetails=new ErrorDetails(exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
