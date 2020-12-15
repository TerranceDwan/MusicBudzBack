package com.budz.exceptions;

public class InvalidRatingException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public InvalidRatingException() {
		super("InvalidRatingException");
	}
}
