package com.revature.controllers;

import java.io.IOException;

import com.revature.security.Authenticate;

import io.javalin.http.Context;

public class UserControllerImpl implements UserController{
	
	public Authenticate auth;

	public UserControllerImpl (Authenticate auth) {
		this.auth = auth;
	}
	
	
	@Override
	public void validate (Context ctx) throws IOException {
		
	
			
		String username = ctx.formParam("username");		
		String password = ctx.formParam("password");
		String isManager = ctx.formParam("isManager");
		
		boolean check = false;
		
		if (isManager == "on") {
			check = true;
		} else if (isManager == "null") {
			check = false;
		}
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(isManager);

		
		boolean validated = auth.validate(username, password); //check for username and password
		
		if (validated && (check == true)) { // if true and isManager, opens Finance Manager Main Menu
			
			ctx.sessionAttribute("username", username);
			ctx.sessionAttribute("access", true);
			
			ctx.res.sendRedirect("FinanceManager.html"); // Finance Manager Main Menu
			
		} else if (validated && (check == false)) { // if true and isManager = null (false), opens up Employee Main Menu
					
			ctx.sessionAttribute("username", username);
			ctx.sessionAttribute("access", true);
			
			ctx.res.sendRedirect("FinanceManager.html"); //create a new html page in src/main/resources/public for an Employee Main Menu
												 //and change the index2.html					
		} else {
			/*Can add another html page if you like that says not a valid login
			 * credentials or copy the LoginPage.html and just add a header or something in the body
			 * that says "Invalid username / password, try again!
			 */
			ctx.res.setStatus(401);
		}
			
		//return page;
	}
	
	

}
