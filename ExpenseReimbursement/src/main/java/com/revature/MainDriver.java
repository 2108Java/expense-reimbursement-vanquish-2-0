package com.revature;

import com.revature.controllers.RequestHandler;

import io.javalin.Javalin;


public class MainDriver {

	public static void main(String[] args) {
		
		 Javalin app = Javalin.create(config -> config.addStaticFiles (
				 staticFiles -> 
				 {
					 staticFiles.directory = "/public";
				 }
				 )).start(9000);
			  

		
		//Open postman and copy this! ---> http://localhost:9000/ <----
		//And paste it in the GET input box in Postman
		//Just uncomment this one if you want to try your connection to Postman
		
//				Click the line and press Ctrl + Shift + C
//									|
//									|
//									|
//									v		
//		app.get("/", ctx -> ctx.json("I'm in javalin!"));
		
		
		RequestHandler.setUpEndpoints(app);
		
	}

}
