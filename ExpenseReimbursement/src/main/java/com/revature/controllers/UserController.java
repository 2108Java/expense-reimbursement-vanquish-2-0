package com.revature.controllers;

import java.io.IOException;

import io.javalin.http.Context;

public interface UserController {
	
	// handles data transfer from web to javalin

	public void validate(Context ctx) throws IOException;
	
	
}
