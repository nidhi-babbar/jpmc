package com.jpmc.interview.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jpmc.interview.exception.BadRequestException;





@ControllerAdvice
public class ExceptionHandlingAdvice {
	
	
	   @ExceptionHandler(value = {BadRequestException.class})
	   public ResponseEntity<Object> handleBadRequestException(Exception ex) {
	        return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	    }
	  
	 
	  
	
}
