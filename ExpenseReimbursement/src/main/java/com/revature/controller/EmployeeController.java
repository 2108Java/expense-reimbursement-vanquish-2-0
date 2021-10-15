package com.revature.controller;

import com.revature.service.EmployeeService;

public class EmployeeController {
	
	EmployeeService employeeService = new EmployeeService();
	
	public int retreiveEmployeeId(){
		
		return employeeService.getEmployeeId();
	}
	
	public String retrieveEmployeeEmail() {
		
		return employeeService.getEployeeEmail();
	}
	
	public String retrieveEmployeeUsername() {
		return employeeService.getEmployeeUsername();
	}
	
	public String retrieveEmployeePassword() {
		
		return employeeService.getEmployeePassword();
		
	}

}
