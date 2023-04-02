package com.example.pons.exception;

public class ErrorDetails {
	
	private String message;
	private String path;
	public ErrorDetails(String message, String path) {
		super();
		this.message = message;
		this.path = path;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
