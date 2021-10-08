package com.reveture.controller;

import java.util.ArrayList;
import java.util.List;

import com.revature.DAO.RequestDAOImp;
import com.revature.Models.EmployeeRequest;
import com.revature.Models.ReimbursementRequest;
import com.reveture.service.EmployeeService;

import io.javalin.http.Context;

public class EmployeeController {
	RequestDAOImp re= new RequestDAOImp();
	private List<EmployeeRequest> employee= new ArrayList<>();
	
	EmployeeRequest er= new EmployeeRequest();
	
	
	  EmployeeService es = new EmployeeService();
	  public EmployeeController(RequestDAOImp re,EmployeeService es ) {
		  this.re=re;
		  this.es=es;
	  }
	
	
	/*public Object seeEmployee(Context ctx) {
		String position1 = ctx.pathParam("position");
		System.out.println(position1);
		int position = Integer.parseInt(position1);
		EmployeeRequest re1= null;
		
		//return new EmployeeRequest();
		
		try {
			 re1= es.getEmployeeByEmail(position);
			System.out.println(re1);
		}catch (IndexOutOfBoundsException e) {
			System.out.println(e); // We shoould be using log4j
		}
				
		
		if( re1 != null) {
			ctx.res.setStatus(200);
			return re1;
		}else {
			ctx.res.setStatus(404);
		//resource not found!
			 //return null;
			return new Message("Employee object with position: " + position + " does not exist");
//			return new Fruit("does not exist");
//			return null; //we don't want to break our server!
		}
		}*/
		
	  public EmployeeRequest select (Context ctx){
			String position1 = ctx.pathParam("position");
			int position = Integer.parseInt(position1);
			System.out.println(position1);
			employee= re.select();
			
			return this.employee.get(position);
		}
		
	  /*public EmployeeRequest selectEmail (Context ctx){
			String position1 = ctx.pathParam("position");
			//int position = Integer.parseInt(position1);
			System.out.println(position1);
			employee = re.selectByEmail(position1);
			
			return null;
		}*/
	  
	  public void insert(Context ctx) {
		  String email = ctx.pathParam("email");
		  String retype = ctx.pathParam("reimbursement_type");
		  String description = ctx.pathParam("description");
		  String status = ctx.pathParam("status");
		  String timeOfRequest = ctx.pathParam("time_of_request");
		  String position = ctx.pathParam("position");
		  double amount = Integer.parseInt(position);
		  
		  EmployeeRequest er= new EmployeeRequest(email, retype, description, status, timeOfRequest, amount );
		  re.insert(er);
		  
		  
	  }
		
		
	public List<EmployeeRequest>  seeAll() {
		
			
			return es.seeAll();
			
			
			
			//return allEmployee;
			
		}
		
		//return null;
	

}
