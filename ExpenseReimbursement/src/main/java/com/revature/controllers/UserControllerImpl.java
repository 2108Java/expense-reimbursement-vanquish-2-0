package com.revature.controllers;

import com.revature.service.AuthService;
import com.revature.service.ReimbursmentService;
import com.revature.service.UserService;

import io.javalin.http.Context;

public class UserControllerImpl  implements UserControllerInterface{
	
	private UserService userService;
	private AuthService authService;
	private ReimbursmentService requestSerive;
		
	public UserControllerImpl(UserService userService, AuthService authService, ReimbursmentService requestSerive) {
		super();
		this.userService = userService;
		this.authService = authService;
		this.requestSerive = requestSerive;
	}

	@Override
	public boolean authenticate(String username, String password) {
		//What would I need to authenticate a user?
		
//		String username = ctx.queryParam("username");
//		String password = ctx.queryParam("password");
		
		Boolean access = authService.validate(username, password);
		return false;
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewPendingRequest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewPastRequests() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RequestReinbursment() {
		// TODO Auto-generated method stub
		
	}

}
