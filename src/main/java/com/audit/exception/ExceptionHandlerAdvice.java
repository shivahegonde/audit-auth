package com.audit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.audit.model.AuthenticationResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice {

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> validationExceptions(MethodArgumentNotValidException ex) {
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			log.error(error.getDefaultMessage());
		});
		return new ResponseEntity<String>("Give Username and Password in proper-format", HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> exception(Exception e) {
		log.error(e.getMessage());
		AuthenticationResponse authenticationResponse = new AuthenticationResponse("Invalid", "Invalid","Invalid", false);
		return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
	}

	@ExceptionHandler(value = ProjectManagerNotFoundException.class)
	@ResponseBody
	public ResponseEntity<?> handleValidationException(ProjectManagerNotFoundException projectManagerNotFoundException) {
		return new ResponseEntity<>(projectManagerNotFoundException.getMessage(), HttpStatus.OK);
	}
}
