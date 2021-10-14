package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Request;

import io.javalin.http.Context;

public class RequestController {

	public List<Request> initializeList() {
		List<Request>  requestList = new ArrayList<>();
		
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
