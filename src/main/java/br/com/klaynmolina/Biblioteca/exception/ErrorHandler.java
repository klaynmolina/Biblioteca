package br.com.klaynmolina.Biblioteca.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Controle de exceptions
@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFound e, HttpServletRequest request){
		String error = "Resource not found.";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError se = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(se);
	}
	
	@ExceptionHandler(DatabaseError.class)
	public ResponseEntity<StandardError> database(DatabaseError e, HttpServletRequest request){
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError se = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(se);
	}
}
