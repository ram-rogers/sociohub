package com.ram.sociohub.exception;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException() {
		super("Could not found the user. ");
	}

}