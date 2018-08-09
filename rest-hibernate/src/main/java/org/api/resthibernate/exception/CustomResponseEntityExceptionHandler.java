package org.api.resthibernate.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception exception, WebRequest request) {
		
		CustomException ce = new CustomException(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(ce, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(EmployeNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception exception, WebRequest request) {
		
		CustomException ce = new CustomException(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(ce, HttpStatus.NOT_FOUND);
	}
}	
