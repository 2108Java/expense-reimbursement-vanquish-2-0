package com.revature;


import com.revature.controller.RequestController;
import com.revature.controller.RequestHandler;

import io.javalin.Javalin;

public class MainDriver {
	

	

	public static void main(String[] args) {
		
		
		
		
//		Javalin app = Javalin.create(config -> config.addStaticFiles("/")).start(9000);
		
//		Javalin app = Javalin.create().start(9000);
//		app.get(("/"), ctx -> ctx.json("Hello there "));
		
		
		//replaced with a debugged way below
		Javalin app = Javalin.create(config -> config.addStaticFiles("/")).start(9000);
		
//		app.get("$\\{name}", ctx -> { // the {} syntax does not allow slashes ('/') as part of the parameter
//		    ctx.result("Hello: " + ctx.pathParam("name"));
//		});
		
//		RequestHandler rq = new RequestHandler();
		
		//this resolves the issue of not being able to have "/" in "request/{request_id}"
//		Javalin app = Javalin.create(config -> config.addStaticFiles(
//				staticFiles ->
//				{
//					staticFiles.directory = "/public";
//				}
//				)).start(9000);
		
		RequestHandler.setupEndPoints(app);
		
		//use controller to insert a request into databse vis service->dao
		RequestController requestController = new RequestController();
		requestController.create();
		
	}

}
