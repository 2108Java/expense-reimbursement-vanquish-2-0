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
		
		//controller retrieves request object fields from ctx, then passes request object to  service, 
		//which calls dao, which inserts request obj to database
		//this can be tested in postman by passing request object fields to check functionality
		app.put("/request", ctx -> ctx.json(requestController.createRequest(ctx)));
		
 
	}

}
