package com.example.pons.exception;

public class ExistingUserException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExistingUserException(String errorMsg) {
		super(errorMsg);
	}
}
