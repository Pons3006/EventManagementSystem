package com.example.pons.exception;

public class IplMatchExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public IplMatchExistException(String string) {
		super(string);
	}

}
