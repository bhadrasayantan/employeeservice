package com.example.employeeservice.exceptions;

public class NoDataFoundException extends RuntimeException{

	public NoDataFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoDataFoundException(String entityName,String message) {
		super(entityName+":"+message);
		// TODO Auto-generated constructor stub
	}
	

}
