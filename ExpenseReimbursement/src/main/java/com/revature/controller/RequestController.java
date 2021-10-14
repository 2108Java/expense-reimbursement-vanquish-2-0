package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Request;

import io.javalin.http.Context;

public class RequestController {

	public List<Request> initializeList() {
		List<Request>  requestList = new ArrayList<>();
		
		requestList.add(new Request(1, "Certification", 200, "Java certification", "pending", "10/14/2021"));
		requestList.add(new Request(2,"Travel", 100, "Travel expense", "pending", "10/14/2021"));
		requestList.add(new Request(3,"Lodging", 200, "Lodging expense", "pending", "10/14/2021"));
		
		return requestList;
				
	}
	
	
	public Request getRequest(Context ctx) {
		
		return null;
	}

	
	public List<Request> getAllRequests(Context ctx) {
		
		List<Request> requestList = new ArrayList<>();
		
		
		return requestList;
	}

		
}
