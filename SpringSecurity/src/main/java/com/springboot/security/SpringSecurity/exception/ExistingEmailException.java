package com.springboot.security.SpringSecurity.exception;

public class ExistingEmailException extends Exception {

	
	public ExistingEmailException(String message) {
        super(message);
    }
}
