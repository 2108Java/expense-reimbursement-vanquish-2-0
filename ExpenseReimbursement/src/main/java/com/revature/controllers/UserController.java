package com.revature.controllers;

import io.javalin.http.Context;

public interface UserController {
	
	// handles data transfer from web to javalin

	public String validate(Context ctx);
}
