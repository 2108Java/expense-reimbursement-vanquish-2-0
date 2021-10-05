package com.reveture.controller;

import com.revature.Models.ReimbursementRequest;
import com.reveture.service.EmployeeService;

import io.javalin.http.Context;

public class EmployeeController {
	private static EmployeeService es = new EmployeeService();
	
	
	public Object seeEmploee(Context ctx) {
		String positionString = ctx.pathParam("position");
		int position = Integer.parseInt(positionString);
		ReimbursementRequest re= null;
		
		try {
			re = es.getEmployeeById(position);
		}catch (IndexOutOfBoundsException e) {
			System.out.println(e); // We shoould be using log4j
		}
				
		
		if(re != null) {
			ctx.res.setStatus(200);
			return re;
		}else {
			ctx.res.setStatus(404); //resource not found!
			
			return new Message("Fruit object with position: " + position + " does not exist");
//			return new Fruit("does not exist");
//			return null; //we don't want to break our server!
		}
		
		//return null;
	}

}
