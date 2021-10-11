package com.reveture.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import com.revature.Models.EmployeeRequest;
import com.revature.Models.SignUp;
import com.reveture.service.AutenticateService;
import com.reveture.service.EmployeeService;
import com.reveture.service.SignupService;

import io.javalin.http.Context;

public class Authenticate {
	
	public AutenticateService authService;
	public SignupService empService;
	
	public Authenticate(AutenticateService authService, SignupService empService) {
		super();
		this.authService = authService;
		this.empService = empService;
	}
	public void authenticate(Context ctx) throws ServletException, IOException  {
		
		String email =ctx.queryParam("username");
		String password= ctx.queryParam("password");
		String page = "";
		
		//String password;
		//String email;
		boolean authenticated = authService.authenticate (email, password);
		/*if(ctx.queryParam("username").equals("user") && ctx.queryParam("password").equals("p4ss")) {
			
			
			page = "request.html";
		}
		else {
			page="failed.html";
		}*/
		if(authenticated) {
			SignUp er= empService.getEmployeeByEmail(email);
			ctx.sessionAttribute("employee", er);
			
			
			ctx.res.sendRedirect("request.html");
			
		}
else {
			
			ctx.res.setStatus(401);
		}
		
		//return page;
		
	}

}
