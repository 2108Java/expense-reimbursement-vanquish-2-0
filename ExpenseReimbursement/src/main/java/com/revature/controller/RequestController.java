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

//	List<Request> requestList = new ArrayList<>();
//	public List<Request> initializeList() {
//		
//		requestList.add(new Request(1, "Certification", 200, "Java certification", "pending", "10/14/2021", 1));
//		requestList.add(new Request(2,"Travel", 100, "Travel expense", "pending", "10/14/2021", 2));
//		requestList.add(new Request(3,"Lodging", 200, "Lodging expense", "pending", "10/14/2021",3));
//		requestList.add(new Request(4, "Certification", 150, "Another certification", "pending", "10/14/2021",4));
//		requestList.add(new Request(5,"Travel", 100, "Travel expense", "pending", "10/14/2021",5));
//		requestList.add(new Request(6,"Lodging", 500, "Lodging expense", "pending", "10/14/2021",6));
//		
//		return requestList;
//				
//	}
	
	
	public Request getRequestById(Context ctx) {
		
		//returning a Request that employee wants
		// this id should match the one in the handler
		String stringId = ctx.formParam("requestId");
		int requestId = Integer.parseInt(stringId);
		
		ctx.res.setStatus(200);
		
		return requestService.getRequestById(requestId);
		
	}

	
	public List<Request> getRequestList(Context ctx) {
		
		ctx.res.setStatus(200);

		return requestService.getAllRequests();
	}
	
	public void createRequest(Request request){//should take ctx object eventually
		
		//How to retrieve the data fields from ctx to build a request object?
		
		//let's assume that's done and hardcode them below for now:
		
		requestService.submitRequest(request);
		
	}


	public void processRequest(int requestId, String decision) {
		
		RequestDao requestDao = new RequestDao();
		
		requestDao.updateRequest(requestId, decision);
		
	}
	
	public boolean createRequest(Context ctx) {
		
		//creating a brand new request object using info provided in ctx:
		
		ctx.res.setStatus(200);
		
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
		
		return success;
	}

		
}
