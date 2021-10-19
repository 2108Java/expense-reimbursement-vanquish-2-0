package com.revature.service;

import java.util.List;

import com.revature.dao.RequestDao;
import com.revature.models.Request;

//instead of having a dummy database requestList inside the controller, we can use requestService object to getAllRequests
	//the service class talks to the dao class, and the dao class gets info directly from database
	//hence, we need an instance of service class inside the controller, and an instance of the dao class inside the service

public class RequestService {
	
	
	RequestDao requestDao = new RequestDao();
	
	
	public List<Request> getAllRequests(){
		
		return requestDao.selectAllRequests();
		
	}
	
	public Request getRequestById(int requestId) {
		
		return requestDao.selectRequestById(requestId);
	}
	
	public void submitRequest(Request request) {
		requestDao.insertRequest(request);
	}

	public List<Request> getEmployeeRequests(int employeeId) {
		
		return requestDao.selectEmployeeRequests(employeeId);
	}

	public List<Request> getEmployeePendingRequests(int employeeId) {
		
		return requestDao.selectEmployeePendingRequests(employeeId);
	}

}
