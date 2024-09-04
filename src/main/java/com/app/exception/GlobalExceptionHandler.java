package com.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	// Handle OrganizerNotFoundException
	@ExceptionHandler(OrganizerNotFoundException.class)
	public ResponseEntity<String> handleOrganizerNotFoundException(OrganizerNotFoundException ex) {
		String message = "Organizer Not Found: " + ex.getMessage();
		logger.error(message); // Log the error message
		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}

	// Handle VenueNotFoundException
	@ExceptionHandler(VenueNotFoundException.class)
	public ResponseEntity<String> handleVenueNotFoundException(VenueNotFoundException ex) {
		String message = "Venue Not Found: " + ex.getMessage();
		logger.error(message); // Log the error message
		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}

	// Handle EventNotFoundException
	@ExceptionHandler(EventNotFoundException.class)
	public ResponseEntity<String> handleEventNotFoundException(EventNotFoundException ex) {
		String message = "Event Not Found: " + ex.getMessage();
		logger.error(message); // Log the error message
		return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
	}

	// Add more exception handlers as needed
}
