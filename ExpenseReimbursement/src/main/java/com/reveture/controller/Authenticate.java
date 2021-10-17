package com.reveture.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import com.revature.DAO.SignupDAOImp;
import com.revature.DAO.UserDAO;
import com.revature.Models.EmployeeRequest;
import com.revature.Models.SignUp;
import com.revature.Models.User;
import com.reveture.service.AutenticateService;
import com.reveture.service.EmployeeService;
import com.reveture.service.SignupService;

import io.javalin.http.Context;

public class Authenticate {
	
	public AutenticateService authService;
	public SignupService empService;
	public SignupDAOImp signup;
	UserDAO dao;
	public Authenticate(AutenticateService authService) {
		super();
		this.authService = authService;
		//this.empService = empService;
	}
	/*public String authenticate(Context ctx) throws ServletException, IOException  {
		
		String email =ctx.formParam("username");
		System.out.println(email);
		String password= ctx.formParam("password");
		System.out.println(password);
		String page = "";
		
		//String password;
		//String email;
		boolean authenticated = authService.authenticate (email, password);
		/*if(ctx.queryParam("username").equals("user") && ctx.queryParam("password").equals("p4ss")) {
			
			
			page = "request.html";
		}
		else {
			page="failed.html";
		}
		if(authenticated) {
			SignUp er= empService.getEmployeeByEmail(email);
			System.out.println(email);
			ctx.sessionAttribute("employee", er);
			
			
			ctx.res.sendRedirect("request.html");
			
		}
else {
			
			ctx.res.setStatus(401);
		}
		String x="login.html";
		
		return x ;
		
	}*/
	public String authenticate(Context ctx) throws ServletException, IOException {
		
		String username =ctx.formParam("username");
		System.out.println(username);
		
		String password= ctx.formParam("password");
		System.out.println(password);
		
		String page = "";
		if(ctx.formParam("username").equals("user") 
				&& ctx.formParam("password").equals("p4ss")){
			
					ctx.sessionAttribute("access", true); //we're now giving them access!
				//page = "PlanetsLandingPage.html";
					page = "list.html";
				}else {
					ctx.sessionAttribute("access",false);
					//page = "failedLogin.html";
					page = "fail.html";
				}
		
//		if(service.authenticate(ctx.queryParam(username))) What we would do in a full stack. 
		
		return page;
	
		}
	
	public String managerAuthen(Context ctx) throws ServletException, IOException{

		String username =ctx.formParam("username");
		System.out.println(username);
		
		String password= ctx.formParam("password");
		System.out.println(password);
		String page = "";
		if(ctx.formParam("username").equals("manager") 
				&& ctx.formParam("password").equals("manager")){
			
					ctx.sessionAttribute("access", true); //we're now giving them access!
				//page = "PlanetsLandingPage.html";
					page = "list1.html";
				}else {
					ctx.sessionAttribute("access",false);
					//page = "failedLogin.html";
					page = "fail1.html";
				}
		
//		if(service.authenticate(ctx.queryParam(username))) What we would do in a full stack. 
		
		return page;
	}
		
		
	}


