package com.masaischool.Exception;

public class NoRecordFoundException extends Exception{

	public NoRecordFoundException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return "No Record Found " + getMessage();
	}
	
	
	
}
