package com.revature;

import io.javalin.Javalin;

public class MainDriver {

	public static void main(String[] args) {
		
		Javalin app = Javalin.create().start(9000);
		
		
		//Open postman and copy this! ---> http://localhost:9000/ <----
		//And paste it in the GET input box in Postman
		//Just uncomment this one if you want to try your connection to Postman
		
//				Click the line and press Ctrl + Shift + C
//									|
//									|
//									|
//									v		
//		app.get("/", ctx -> ctx.json("Connecting to Postman! This is a test"));
//		app.get(("\\{\"user_id\" : [0-9]*\\}"), ctx->ctx.json("connecting again to postman"));
		
		app.get("/", ctx -> ctx.html("<h1>Connecting to Postman! This is a test</h1>"));
//		
		
	}

}
