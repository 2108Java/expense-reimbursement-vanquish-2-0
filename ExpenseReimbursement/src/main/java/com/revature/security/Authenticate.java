package com.revature.security;

import io.javalin.http.Context;

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

