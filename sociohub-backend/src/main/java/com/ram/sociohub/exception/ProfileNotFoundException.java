package com.ram.sociohub.exception;

public class ProfileNotFoundException extends RuntimeException{
	public ProfileNotFoundException() {
		super("Could not found the Profile. ");
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}
}

