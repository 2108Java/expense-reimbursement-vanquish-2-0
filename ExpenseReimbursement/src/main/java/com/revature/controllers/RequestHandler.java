package com.revature.controllers;

import io.javalin.Javalin;

public class RequestHandler {

	public static void setupEndPoints(Javalin app) {
		
		ReimbursementController reimbursementController = new ReimbursementController();
		
		reimbursementController.initalizeList();
		
		app.get("/request/", ctx -> ctx.json(reimbursementController.getRequest(ctx)));
		app.get("/requests", ctx -> ctx.json(reimbursementController.getAllRequests(ctx)));
	}

}