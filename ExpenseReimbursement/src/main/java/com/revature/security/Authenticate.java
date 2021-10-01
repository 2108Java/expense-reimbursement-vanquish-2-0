package com.revature.security;

public interface Authenticate {
	
	//handles user or login validation
	/*
	 * this could serve as a functional interface
	 * One and only one method
	 * 
	 * 
	 * 
	 */

	public boolean validate(String username, String password);
}

