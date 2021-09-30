package com.revature.controllers;

import com.revature.security.Authenticate;

import io.javalin.http.Context;

public class UserControllerImpl implements UserController{
	
	public Authenticate auth;

	public UserControllerImpl (Authenticate auth) {
		this.auth = auth;
	}
	
	@Override
	public String validate (Context ctx) {
		
		String page = "";
			
		String username = ctx.formParam("username");		
		String password = ctx.formParam("password");
		
		System.out.println(username);
		System.out.println(password);
		
		if (auth.validate(username, password) == true) {
			page = "http://127.0.0.1:5500/JavalinAgain/index2.html";
		} else {
			page = "http://127.0.0.1:5500/JavalinAgain/index3.html";
		}
		
		
		
			
		return page;
	}
	
	

}
