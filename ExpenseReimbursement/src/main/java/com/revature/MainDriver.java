package com.revature;

import com.revature.DAO.RequestDAOImp;
import com.revature.DAO.SignupDAOImp;
import com.revature.Models.EmployeeRequest;
import com.reveture.controller.RequestMapping;

import io.javalin.Javalin;

public class MainDriver {

	public static void main(String[] args) {
		
		 Javalin app = Javalin.create(config -> config.addStaticFiles(
					staticFiles ->
					{
						staticFiles.directory = "/public";
					}
					)).start(9301);
		RequestMapping.settingUpEndpoints(app);
		//SignupDAOImp a= new SignupDAOImp();
		
		//a.insert();
	//	a.select();
		EmployeeRequest e =new EmployeeRequest();
		 
			
		RequestDAOImp r=  new RequestDAOImp();
		r.update(e);
		
		
		//Open postman and copy this! ---> http://localhost:9000/ <----
		//And paste it in the GET input box in Postman
		//Just uncomment this one if you want to try your connection to Postman
		
//				Click the line and press Ctrl + Shift + C
//									|
//									|
//									|
//									v		lm;'fkll;
//		app.get("/", ctx -> ctx.json("Connecting to Postman!"));
		
		
		
		
		
		
		
	}

}