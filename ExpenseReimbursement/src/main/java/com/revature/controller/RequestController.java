package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Request;
import com.revature.models.Manager;

import io.javalin.http.Context;

public class RequestController {
	
	public List<Request>  requestList = new ArrayList<>();
	public List<Employee>  employeeList = new ArrayList<>();
	public List<Manager>  managerList = new ArrayList<>();

	public List<Request> initializeList() {
		
		requestList.add(new Request(1, "Certification", 200, "Java certification", "pending", "10/14/2021"));
		requestList.add(new Request(2,"Travel", 100, "Travel expense", "pending", "10/14/2021"));
		requestList.add(new Request(3,"Lodging", 200, "Lodging expense", "pending", "10/14/2021"));
		requestList.add(new Request(4, "Certification", 150, "Another certification", "pending", "10/14/2021"));
		requestList.add(new Request(5,"Travel", 100, "Travel expense", "pending", "10/14/2021"));
		requestList.add(new Request(6,"Lodging", 500, "Lodging expense", "pending", "10/14/2021"));
		
		return requestList;
				
	}
	
	public List<Employee> initializeEmployeeList(){
		
		employeeList.add(new Employee(1, "username1", "password"));
		employeeList.add(new Employee(2, "username2", "password"));
		employeeList.add(new Employee(3, "username3", "password"));
		employeeList.add(new Employee(4, "username4", "password"));
		employeeList.add(new Employee(5, "username5", "password"));
		employeeList.add(new Employee(6, "username6", "password"));
		
		return employeeList;
	}
	
	
	public List<Manager> initializeManagerList(){
		
		managerList.add(new Manager(1, "managerUsername1", "password"));
		managerList.add(new Manager(2, "managerUsername2", "password"));
		managerList.add(new Manager(3, "managerUsername3", "password"));
		
		return managerList;
		
	}
	
	
	public Request getRequest(Context ctx) {
		
		//returning a Request that employee wants:
		String stringId = ctx.queryParam("request_id");
		int request_id = Integer.parseInt(stringId);
		
		ctx.res.setStatus(418);
		
		return this.requestList.get(request_id);
		
	}

	
	public List<Request> getAllRequests(Context ctx) {
		
		ctx.res.setStatus(200);
			
		return this.requestList;
	}
	
	public void updateRequest(Context ctx) {
		
	
		ctx.res.setStatus(200);
		//selecting the request to be updated:
		// invoking getRequest(ctx) method above which uses ctx queryParam to select a request 
		Request request = this.getRequest(ctx);
		
		//this method should be accesses to managers only
		// we can enforce that by verifying that the username and password matches one of the rows in magagers table:
		
		String username = ctx.queryParam("managerUsername");
		String password = ctx.queryParam("managerPassword");
		
		//Loop through managerList to finding matchting username of that given in ctx
		for( Manager manager : managerList) {
			if(manager.getMangerUsername().equals(username) && manager.getManagerPassword().equals(password)) {
				
				
				//can add logic for approving or rejecting request here e.g if this.request.amount > 1000 reject
				
				
				//modifying the request:
				request.setRequest_status("approved");
			}
		}
		
	}

		
}
