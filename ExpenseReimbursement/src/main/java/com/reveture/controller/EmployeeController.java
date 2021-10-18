package com.reveture.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.revature.DAO.RequestDAOImp;
import com.revature.DAO.SignupDAOImp;
import com.revature.Models.EmployeeRequest;
import com.revature.Models.SignUp;
//import com.revature.Models.ReimbursementRequest;
import com.reveture.service.EmployeeService;

import io.javalin.http.Context;

public class EmployeeController {
	private static final Logger loggy = Logger.getLogger(EmployeeController.class);
	RequestDAOImp re;
   // ArrayList employee= new ArrayList();
	private List<EmployeeRequest> employee= new ArrayList<>();
	EmployeeRequest er= new EmployeeRequest();
	SignUp s=new SignUp();
	
	SignupDAOImp signupdao;
	  EmployeeService es = new EmployeeService(re);
	   
	  public void init() {
		  re= new RequestDAOImp ();
		  signupdao =new SignupDAOImp();
		  
	  }
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
		
	  public Object selectById (Context ctx){
		  loggy.setLevel(Level.ALL);
			
		  
		  String position1 = ctx.pathParam("position");
			int request_id = Integer.parseInt(position1);
			loggy.info("request id is : "+ request_id);

			//System.out.println(position1);
			//init();
			try {
				EmployeeRequest request=re.selectById(request_id);
				System.out.println(request);
				loggy.info("request is" + request);
				
				
				if(request != null) {
					ctx.res.setStatus(200);
					//System.out.println(request);
				
					return request;
				}else {
					ctx.res.setStatus(404); //resource not found!
					
					//return new Message("Fruit object with position: " + request_id + " does not exist");
//					return new Fruit("does not exist");
//					return null; //we don't want to break our server!
				}
				}
			catch (IndexOutOfBoundsException e) {
				System.out.println(e); // We shoould be using log4j
			}
				return new Message("Fruit object with position: " + request_id + " does not exist");
				
			}
			
	 
	  public List<EmployeeRequest> selectByStatus (Context ctx){
		  
		  loggy.setLevel(Level.ALL);
			String status = ctx.pathParam("status");
			System.out.println(status);
			loggy.info("stutus is" + status);
			
			try {
				EmployeeRequest request1=re.selectByStatus(status);
				employee.add(request1);
				
				System.out.println(employee);
				loggy.info("employee is" + employee);
				if(employee != null) {
					ctx.res.setStatus(200);
					
				
					return employee;
				}else {
					ctx.res.setStatus(404); //resource not found!
					
					
				}
			}
	  catch (IndexOutOfBoundsException e) {
			System.out.println(e); // We shoould be using log4j
		}
			//return new Message("Fruit object with position: " + status + " does not exist");
//			return new Fruit("does not exist");
			
			
			return this.employee;
		}
	  
	  public void insert(Context ctx) throws IOException {
		  
		  String id = ctx.formParam("request_id");
		  int request_id = Integer.parseInt(id);
		  loggy.info("request_id" + request_id);
		  
		  String email = ctx.formParam("email");
		  System.out.println(email);
		  
		  loggy.info("email is" + email);
		  
		  String reimbursment_type= ctx.formParam("reimbursment_type");
		  System.out.println(reimbursment_type);
		  
		  String description = ctx.formParam("description");
		  System.out.println(description);
		  loggy.info("description is" + description);
		 
		  String status = ctx.formParam("status");
		  System.out.println(status);
		  loggy.info("status is" + status);
		  
		  String time_of_request = ctx.formParam("time_of_request");
		  
		  System.out.println(time_of_request);
		  loggy.info("time_of_request is" + time_of_request);
		 // String position = ctx.formParam("position");
		  String amount = ctx.formParam("amount");
		  //int amount = Integer.parseInt(amount1);
		  
		  System.out.println(amount);
		  loggy.info("amount is" + amount);
		  
		  EmployeeRequest er= new EmployeeRequest(request_id,email,reimbursment_type,description, status, time_of_request, amount);
		  re.insert(er);
		  
		  ctx.res.sendRedirect("http://localhost:9303/list.html");
		  
		  
		  
	  }
	  
	  public void register(Context ctx) throws IOException {
		  
		  String id = ctx.formParam("employee_id");
		  int employee_id = Integer.parseInt(id);
		  System.out.println(employee_id);
		  loggy.info("employee_id is" + employee_id);
		  
		  String firstname = ctx.formParam("firstname");
		  System.out.println(firstname);
		  
		  String lastname= ctx.formParam("lastname");
		  System.out.println(lastname);
		  
		  String email = ctx.formParam("email");
		  System.out.println(email);
		 
		  String phone= ctx.formParam("phone");
		  System.out.println(phone);
		  
		 SignUp sign= new SignUp(employee_id, firstname,lastname,email,phone);
		  
		 System.out.println(sign);
		 SignupDAOImp signupdao = new SignupDAOImp();
		 signupdao.insert(sign);
		 
		 
		 ctx.res.sendRedirect("http://localhost:9303/login.html");
		 
		  
	  }
		  
	  public void update(Context ctx) throws IOException {
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
		 // int time_of_request = Integer.parseInt(time_of_request1);
		  System.out.println(time_of_request);
		 // String position = ctx.formParam("position");
		  String amount = ctx.formParam("amount");
		  //int amount = Integer.parseInt(amount1);
		  
		  System.out.println(amount);
		  EmployeeRequest er= new EmployeeRequest(request_id,email,reimbursment_type,description, status, time_of_request, amount);
		  System.out.println(er);
		  re.update(er);
		  ctx.res.sendRedirect("http://localhost:9303/list1.html");
		  
	  }
		
		
	


	public List<EmployeeRequest>  seeAll() {
		
			
			return es.seeAll();
			
			
			
			//return allEmployee;
			
		}
	

}
