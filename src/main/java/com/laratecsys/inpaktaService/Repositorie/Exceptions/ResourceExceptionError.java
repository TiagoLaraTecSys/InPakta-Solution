package com.laratecsys.inpaktaService.Repositorie.Exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.laratecsys.inpaktaService.Service.exception.AuthorizationException;
import com.laratecsys.inpaktaService.Service.exception.ConstraitException;
import com.laratecsys.inpaktaService.Service.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionError {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		
	}
	
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<StandardError> authorizationException(AuthorizationException e, HttpServletRequest request){
		
		StandardError err = new StandardError(HttpStatus.UNAUTHORIZED.value(), e.getMessage(), (System.currentTimeMillis()));
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
	}
	
	@ExceptionHandler(ConstraitException.class)
	public ResponseEntity<StandardError> constraitForeignKey(ConstraitException e, HttpServletRequest request){
		
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(),e.getMessage(), (System.currentTimeMillis()));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		
	}

}
