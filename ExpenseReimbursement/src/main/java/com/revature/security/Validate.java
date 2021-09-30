package com.revature.security;

import com.revature.repo.UserDAO;

import io.javalin.http.Context;

public class Validate implements Authenticate {
	
	UserDAO database;
	
	public Validate (UserDAO database) {
		this.database = database;
	}

	@Override
	public boolean validate(String username, String password) {
		
//		String page = "";
//		
//		if (ctx.queryParam("username").equals("user") 
//				&& ctx.queryParam("password").equals("p4ss")) {
//			page =  "http://127.0.0.1:5500/JavalinAgain/index.html";
//		}
		
		return database.getLogin(username, password);
	}
	
	

}
