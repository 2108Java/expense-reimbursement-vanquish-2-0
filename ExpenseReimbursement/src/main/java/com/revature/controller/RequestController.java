package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.RequestDao;
import com.revature.models.Request;
import com.revature.service.RequestService;

import io.javalin.http.Context;

public class RequestController {
	
	//instead of having a dummy database rquestList inside the controller, we can use requestService object to getAllRequests
	//the service class talks to the dao class, and the dao class gets info directly from database
	//hence, we need an instance of service class inside the controller, and an instance of the dao class inside the service
	
	RequestService requestService = new RequestService();
	
	//index method (shows all requests)
	public List<Request> getRequestList(Context ctx) {

		ctx.res.setStatus(200);

		//cruises down the layers all way to database and grabs all the requests
		//the ctx is only needed to send back the status in this situation
		return requestService.getAllRequests();
	}

	
	//show method (shows one request by id)
	public Request getRequestById(Context ctx) {

		//returning a Request that employee wants to view using its id
		// this id should match the one in the handler

		//this grabs the id that the user typed in the form and parses it to int
		int requestdInput = Integer.parseInt(ctx.formParam("requestId"));

		ctx.res.setStatus(200);


		//then invokes a service method that grabs a request object when given its id
		return requestService.getRequestById(requestdInput);

	}

	//create method (read)
	public String createRequest(Context ctx) {

		//creating a brand new request object using info provided in ctx:

		boolean success = false;

		int requestIdInput = Integer.parseInt(ctx.formParam("requestId"));
		String requestTypeInput = ctx.formParam("requestType");
		double amountInput = Double.parseDouble(ctx.formParam("amount"));
		String descriptionInput = ctx.formParam("description");
		String requestStatusInput = ctx.formParam("requestStatus");
		String requestDateInput = ctx.formParam("requestDate");
		int employeeIdInput = Integer.parseInt(ctx.formParam("employeeId"));

		Request request = new Request(requestIdInput, requestTypeInput, amountInput, requestStatusInput, descriptionInput, requestDateInput, employeeIdInput);

		requestService.submitRequest(request);

		ctx.res.setStatus(200);
		
		return "Success";
	}
	
	
	//update method
	public boolean approveRequest(Context ctx) {
		
		//by update, we mean a manager updates the status of the request to approved or denied
		
		int requestId = Integer.parseInt(ctx.formParam("requestIdInput"));
		
		requestService.acceptRequest(requestId);
		
		
		ctx.res.setStatus(200);
		return true;
		
	}
	
	
	//delete method
	
	public boolean deleteRequestById(int requestId) {
		boolean success = false;
		
		
		
		return success;
	}


	public List<Request> getRequestsByEmployeeId(Context ctx) {
		
		int employeeIdInput = Integer.parseInt(ctx.formParam("employeeId"));
		
		return requestService.getEmployeeRequests(employeeIdInput);

	}


	public List<Request> getMyPendingRequests(Context ctx) {
		
		int employeeIdInput = Integer.parseInt(ctx.formParam("employeeId"));
		
		ctx.res.setStatus(200);
		return requestService.getEmployeePendingRequests(employeeIdInput) ;
	}


	public List<Request> getRequestsByEmployeeUsername(Context ctx) {
		
		String usernameInput = ctx.formParam("username");
		
		return requestService.getRequestListByEmployeeUsername(usernameInput);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

		
}
