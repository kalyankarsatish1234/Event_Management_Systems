package com.app.exception;

@SuppressWarnings("serial")
public class EventNotFoundException extends RuntimeException{
	
	public EventNotFoundException(String message) {
		super(message);
	}
}
