package com.revature.controllers;

import com.revature.repo.UserDAO;
import com.revature.repo.UserDAOImpl;
import com.revature.security.Authenticate;
import com.revature.security.Validate;

import io.javalin.Javalin;

public class RequestHandler {

	public static void setUpEndpoints (Javalin app) {
		
		UserDAO database = new UserDAOImpl();
		Authenticate auth = new Validate(database);
		UserController user = new UserControllerImpl(auth);
		
		//This is the default page or Home Page
		app.get("/loginPage", ctx -> 
		{		
			ctx.req.getRequestDispatcher("LoginPage.html").forward(ctx.req, ctx.res);			
		}
		);		
	
		//Validates username and password --- com.revature.security - Validate.java
		/*
		 * If you want to try this feature, use Postman
		 * GET > http://localhost:9000/loginPage <---- shows the Login Page (username, password and login button)
		 * POST > http://localhost:9000/validate <---- Go to Body and click "x-www-form-urlencoded"
		 * 											   Then put key value pairs (username : <value>
		 * 																		 password : <value>
		 * 																		 isManager: <true/false>
		 * 
		 */
		app.post("/validate", ctx -> {user.validate(ctx);});
		
		//
		app.post("/logout", ctx -> {
			ctx.consumeSessionAttribute("access");
			ctx.redirect("/loginPage");
		});
		
	}

		
}
