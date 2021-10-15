package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Request;

import io.javalin.http.Context;

public class RequestController {
	
	List<Request>  requestList = new ArrayList<>();

	public List<Request> initializeList() {
		
		requestList.add(new Request(1, "Certification", 200, "Java certification", "pending", "10/14/2021"));
		requestList.add(new Request(2,"Travel", 100, "Travel expense", "pending", "10/14/2021"));
		requestList.add(new Request(3,"Lodging", 200, "Lodging expense", "pending", "10/14/2021"));
		requestList.add(new Request(4, "Certification", 150, "Another certification", "pending", "10/14/2021"));
		requestList.add(new Request(5,"Travel", 100, "Travel expense", "pending", "10/14/2021"));
		requestList.add(new Request(6,"Lodging", 500, "Lodging expense", "pending", "10/14/2021"));
		
		return requestList;
				
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

		
}
