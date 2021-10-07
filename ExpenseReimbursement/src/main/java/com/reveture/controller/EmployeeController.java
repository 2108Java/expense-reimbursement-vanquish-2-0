package com.reveture.controller;

import java.util.List;

import com.revature.DAO.RequestDAOImp;
import com.revature.Models.EmployeeRequest;
import com.revature.Models.ReimbursementRequest;
import com.reveture.service.EmployeeService;

import io.javalin.http.Context;

public class EmployeeController {
	RequestDAOImp re= new RequestDAOImp();
	
	
	
	  EmployeeService es = new EmployeeService(re);
	  public EmployeeController(RequestDAOImp re,EmployeeService es ) {
		  this.re=re;
		  this.es=es;
	  }
	
	
	public Object seeEmployee(Context ctx) {
		String position1 = ctx.pathParam("position");
		System.out.println(position1);
		//int position = Integer.parseInt(positionString);
		EmployeeRequest re1= null;
		
		//return new EmployeeRequest();
		
		try {
			re1 = es.getEmployeeByEmail(position1);
		}catch (IndexOutOfBoundsException e) {
			System.out.println(e); // We shoould be using log4j
		}
				
		
		if(re1 != null) {
			ctx.res.setStatus(200);
			return re1;
		}else {
			ctx.res.setStatus(404);
		//resource not found!
			 return new Message("Fruit object with position: " + position1 + " does not exist");
			//return new Message("Fruit object with position: " + email + " does not exist");
//			return new Fruit("does not exist");
//			return null; //we don't want to break our server!
		}
		}
		
	public List<EmployeeRequest>  seeAll() {
		
			
			return es.seeAll();
			
			
			
			//return allEmployee;
			
		}
		
		//return null;
	

}
