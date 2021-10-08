package com.reveture.controller;

import io.javalin.http.Context;

public class Authenticate {
	public String authenticate(Context ctx) {
		
		System.out.println(ctx.queryParam("username"));
		System.out.println(ctx.queryParam("password"));
		String page = "";
		if(ctx.queryParam("username").equals("user") && ctx.queryParam("password").equals("p4ss")) {
			
			
			page = "request.html";
		}
		else {
			page="failed.html";
		}
		
		return page;
		
	}

}
