package com.revature.controllers;

import com.revature.service.AuthService;
import com.revature.service.ReimbursementService;
import com.revature.service.UserService;

import io.javalin.http.Context;

public class UserControllerI {
	
	private UserService userService;
	private AuthService authService;
	private ReimbursementService requestSerive;
		
	public UserControllerI(UserService userService, AuthService authService, ReimbursementService requestSerive) {
		super();
		this.userService = userService;
		this.authService = authService;
		this.requestSerive = requestSerive;
	}

	public boolean authenticate(Context ctx) {
		boolean authenticated = false; 
		//What would I need to authenticate a user?
		
//		String username = ctx.queryParam("username");
//		String password = ctx.queryParam("password");
		
//		Boolean access = authService.validate(username, password);
		
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");
		return authenticated;
	}

	public void login() {
		// TODO Auto-generated method stub
		
	}

	public void viewPendingRequest() {
		// TODO Auto-generated method stub
		
	}


	public void viewPastRequests() {
		// TODO Auto-generated method stub
		
	}

	public void RequestReinbursment() {
		// TODO Auto-generated method stub
		
	}

	public boolean authenticate(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
