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
		  
		  String id = ctx.formParam("request_id");
		  int request_id = Integer.parseInt(id);
		  //System.out.println(email);
		  
		  String email = ctx.formParam("email");
		  System.out.println(email);
		  
		  String reimbursment_type= ctx.formParam("reimbursment_type");
		  System.out.println(reimbursment_type);
		  
		  String description = ctx.formParam("description");
		  System.out.println(description);
		 
		  String status = ctx.formParam("status");
		  System.out.println(status);
		  
		  String time_of_request = ctx.formParam("time_of_request");
		  System.out.println(time_of_request);
		 // String position = ctx.formParam("position");
		  String amount = ctx.formParam("amount");
		  System.out.println(amount);
		  
		  EmployeeRequest er= new EmployeeRequest(request_id,email,reimbursment_type,description, status, time_of_request, amount);
		  re.insert(er);
		  
		  
	  }
		
		
	


	public List<EmployeeRequest>  seeAll() {
		
			
			return es.seeAll();
			
			
			
			//return allEmployee;
			
		}
		
		//return null;
	

}
