package com.gaurisharma.attendance.app.authentication.exceptions;

public class InvalidUserException extends RuntimeException {
	public InvalidUserException(String message) {
		super(message);
	}
}
