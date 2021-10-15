package com.revature.controller;

import io.javalin.Javalin;

public class RequestHandler {
	
	//This will be used to map endpoints into controllers:
	
	public static void setupEndPoints(Javalin app) {
		
		RequestController requestController = new RequestController();
		AuthenticateController authenticateController = new AuthenticateController();
		
		requestController.initializeList();
		
		app.get("/requests", ctx -> ctx.json(requestController.getAllRequests(ctx)));
		app.get("/request", ctx -> ctx.json(requestController.getRequest(ctx)));
		app.get("/login", ctx -> ctx.redirect(authenticateController.authenticate(ctx)));
		
		//as soon as a users type the url, they get redirected to our the login page which we named LoginPage.html:
		
		app.get("/", ctx -> ctx.redirect("/LoginPage.html"));
	}

}
