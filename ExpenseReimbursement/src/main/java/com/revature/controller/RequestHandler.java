package com.revature.controller;

import io.javalin.Javalin;

public class RequestHandler {
	
	//This will be used to map endpoints into controllers:
	
	public static void setupEndPoints(Javalin app) {
		
		RequestController requestController = new RequestController();
		AuthenticateController authenticateController = new AuthenticateController();
		
		
		app.get("/requests", ctx -> ctx.json(requestController.getRequestList(ctx)));
		app.get("/request", ctx -> ctx.json(requestController.getRequestById(ctx)));
		app.get("/login", ctx -> ctx.redirect(authenticateController.authenticate(ctx)));
		
		//as soon as a user types the url, 
	}

}
