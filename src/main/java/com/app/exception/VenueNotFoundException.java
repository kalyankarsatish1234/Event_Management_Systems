package com.app.exception;

@SuppressWarnings("serial")
public class VenueNotFoundException extends RuntimeException{
	public VenueNotFoundException(String message) {
		super(message);
	}

}
