package br.com.klaynmolina.Biblioteca.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.klaynmolina.Biblioteca.exceptionhandler.erros.DatabaseException;
import br.com.klaynmolina.Biblioteca.exceptionhandler.erros.RemovalException;
import br.com.klaynmolina.Biblioteca.exceptionhandler.erros.StandardError;

@ControllerAdvice(basePackages = "br.com.klaynmolina.Biblioteca.controllers")
public class BibliotecaControllerAdvice {
	
	@ResponseBody
	@ExceptionHandler(RemovalException.class)
	public ResponseEntity<StandardError> removalError(RemovalException removalError){
		
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		
		StandardError error = new StandardError(new Date(), status.value(), removalError.getMessage());
				
		return new ResponseEntity<>(error, status);
	}
	
	@ResponseBody
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException resourceNotFound){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError error = new StandardError(new Date(), status.value(), resourceNotFound.getMessage());
				
		return new ResponseEntity<>(error, status);
	}
	
	@ResponseBody
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> databaseError(DatabaseException databaseError){
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		StandardError error = new StandardError(new Date(), status.value(), databaseError.getMessage());
				
		return new ResponseEntity<>(error, status);
	}
	

}
