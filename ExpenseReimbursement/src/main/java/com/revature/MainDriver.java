package com.revature;


import com.revature.controller.RequestController;
import com.revature.controller.RequestHandler;
import com.revature.models.Request;
import com.revature.service.ManagerService;

import io.javalin.Javalin;

public class MainDriver {
	

	

	public static void main(String[] args) {
		
		
		
		
//		Javalin app = Javalin.create(config -> config.addStaticFiles("/")).start(9000);
		
//		Javalin app = Javalin.create().start(9000);
//		app.get(("/"), ctx -> ctx.json("Hello there "));
		
		
		//replaced with a debugged way below
//		Javalin app = Javalin.create(config -> config.addStaticFiles("/")).start(9000);
		
//		app.get("$\\{name}", ctx -> { // the {} syntax does not allow slashes ('/') as part of the parameter
//		    ctx.result("Hello: " + ctx.pathParam("name"));
//		});
		
//		RequestHandler rq = new RequestHandler();
		
		//this resolves the issue of not being able to have "/" in "request/{request_id}"
		Javalin app = Javalin.create(config -> config.addStaticFiles(
				staticFiles ->
				{
					staticFiles.directory = "/public";
				}
				)).start(9000);
		
		RequestHandler.setupEndPoints(app);
		
		
		//how to test insertRequest()?
			//1)the request object fields are provided by the employee when filling out the html form
			//2)javscript grabs that info and sends it inside of the body of an http request
			//3)the Context object of Javalin grabs the data sent in the http request body and makes it available to java logic inside the controller
			//4)the controller calls its method createRequest(Context ctx) 
			//5) createRequest() invokes the requestService method called submitRequest()
			//6)submitRequest() calls the dao method insertRequest()
			//7)Finally, insertRequest() uses sql statement to insert the row into the requests table
		//use controller to insert a request into database via service->dao
		
		
		//testing request insertion into database
	
//		RequestController requestController = new RequestController();
//		Request request = new Request("Travel", 250, "travel expense","10/15/2021", 2);
//		requestController.createRequest(request);
		
		//testing updating request in the database by manager 
		
//		ManagerService managerService = new ManagerService();
//		managerService.handleRequest(7, "approved");
//		managerService.handleRequest(3, "denied");
		
	}

}
