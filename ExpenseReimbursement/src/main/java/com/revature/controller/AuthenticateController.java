package com.revature.controller;

import io.javalin.http.Context;

public class AuthenticateController {
	
	//if login fails, redirect to login page
	//if it succeeds, redirect to requests landing page
	
	public String authenticate(Context ctx) {
		
		//NB: information is strored within the request
		// the ctx contains the information needed
		
		//one scenario of communication is :
			// the browser sends information on the url. e.g Requests/1
		//another way of communication is through via Query Parameters (through the form)
			//e.g login?username=usr&password=pass
		//a 3rd is for the information to be sent via the request body, in the format of Json
		
		//sanity check:
		System.out.println(ctx.queryParam("username"));
		System.out.println(ctx.queryParam("passowrd"));
		
		String page = "";
		
		if(ctx.queryParam("username").equals("username1")&& ctx.queryParam("password").equals("password")) {
			page = "RequestsLandingPage.html";
		}else {
			page = "FailedLoginPage.html";
		}
		
		return page;
		
	}

}
