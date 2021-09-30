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
		
		
		app.get("/", ctx -> ctx.redirect("http://127.0.0.1:5500/JavalinAgain/index.html"));
		
		//app.get("/", ctx -> ctx.req.getRequestDispatcher("http://127.0.0.1:5500/JavalinAgain/index.html").forward(ctx.req, ctx.res));
		
		app.post("/validate", ctx -> ctx.redirect(user.validate(ctx)));
		
		
	}

		
}
