package com.revature;

import io.javalin.Javalin;

public class MainDriver {
	

	

	public static void main(String[] args) {
		
		
		
		
//		Javalin app = Javalin.create(config -> config.addStaticFiles("/")).start(9000);
		
		Javalin app = Javalin.create().start(9000);
		app.get(("/"), ctx -> ctx.json("Hello there "));
		
	
		
	}

}
