package com.revature;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.util.ajax.JSON;

import com.revature.controllers.*;
import com.revature.models.ReimbursementRequest;

import io.javalin.Javalin;

public class MainDriver {
	

	

	public static void main(String[] args) {
		
		
		
		
//		Javalin app = Javalin.create(config -> config.addStaticFiles("/")).start(9000);
		
		
		//Open postman and copy this! ---> http://localhost:9000/ <----
		//And paste it in the GET input box in Postman
		//Just uncomment this one if you want to try your connection to Postman
		
//				Click the line and press Ctrl + Shift + C
		
//		RequestsDao database = new RequestsDao();
//		
//		database.initialize();
//		
		List<ReimbursementRequest> requestsList = new ArrayList<>();
		
		Javalin app = Javalin.create().start(9000);		
			
		app.get("/request/{i}", ctx -> ctx.json(requestsList.get(0)));
		
		app.get("/requests", ctx -> ctx.html(requestsList.toString()));
		
		Object req = requestsList.get(0);
		
		app.get("/first_request", ctx -> ctx.json(req));
//		app.get(("\\{\"user_id\" : [0-9]*\\}"), ctx->ctx.json("connecting again to postman"));
		
//		app.get("/", ctx -> ctx.html("<h1>Connecting to Postman! This is a test</h1>"));
		
//		RequestHandler rc = new RequestHandler();
//		
		
	}

}
