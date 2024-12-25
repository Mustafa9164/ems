package com.jsp.prc.exception;

public class EmployeeNotFound extends RuntimeException{
	
	private String message;

	public EmployeeNotFound() {
		super();
	}
	public EmployeeNotFound(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
