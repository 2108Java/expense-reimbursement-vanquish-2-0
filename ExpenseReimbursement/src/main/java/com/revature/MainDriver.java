package com.revature;

import com.revature.DAO.SignupDAOImp;

import io.javalin.Javalin;

public class MainDriver {

	public static void main(String[] args) {
		
		Javalin app = Javalin.create().start(9000);
		SignupDAOImp a= new SignupDAOImp();
		
		a.insert();
		a.select();
		
		
		//Open postman and copy this! ---> http://localhost:9000/ <----
		//And paste it in the GET input box in Postman
		//Just uncomment this one if you want to try your connection to Postman
		
//				Click the line and press Ctrl + Shift + C
//									|
//									|
//									|
//									v		
//		app.get("/", ctx -> ctx.json("Connecting to Postman!"));
		
		
		
		
	}

}
