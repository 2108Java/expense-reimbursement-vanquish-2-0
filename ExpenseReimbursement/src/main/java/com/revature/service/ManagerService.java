package com.revature.service;

import com.revature.controller.RequestController;
import com.revature.models.Request;

public class ManagerService {
	
	public boolean handleRequest(int requestId, String decision){
		
		boolean success = false;
		
		//manager accesses the request by its id 
		
		//then modifies its status.
		RequestController requestController = new RequestController();
		
		requestController.processRequest(requestId, decision);
		
		return success;
	}

}
