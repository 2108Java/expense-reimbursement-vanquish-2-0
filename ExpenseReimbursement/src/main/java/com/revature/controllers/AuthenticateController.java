package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;

import com.revature.models.User;
import com.revature.service.AuthenticateService;
import com.revature.service.UserService;

import io.javalin.http.Context;

public class AuthenticateController {
	
	//This controller needs the context
	//context stores request and response info
	//Will use service layer to verify user and set session
	
	private AuthenticateService authService;
	private UserService userService;
	
	public AuthenticateController(AuthenticateService authService, UserService userService) {
		super();
		this.authService = authService;
		this.userService = userService;
	}
	
	public String authenticateUser(Context ctx) throws ServletException, IOException {
		
		String username = ctx.formParam("username");
		String password = ctx.formParam("password");
		
		boolean authenticated = authService.authenticate(username, password);
		
		if(authenticated) {
			
			//redirect to home page
			// give them credentials: using sessions
			
			User user = userService.getUserByUsername(username);
			
			ctx.sessionAttribute("User", user);
			ctx.sessionAttribute("access", "customer");
			
			//to go back into a Get request, must:
				//ask client to send another request
				//the client will use search bar, which is a GET request by definition
			
			ctx.res.sendRedirect("http://localhost:8000/home");
			
		}else {
			ctx.res.setStatus(401);
		}
		return password;
	}
	
	
	
	

}
