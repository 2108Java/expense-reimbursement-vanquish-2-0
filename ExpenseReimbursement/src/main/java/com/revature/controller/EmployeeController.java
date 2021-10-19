package com.revature.controller;

import com.revature.models.Employee;
import com.revature.service.EmployeeService;

public class EmployeeController {
	
	EmployeeService employeeService = new EmployeeService();
	//index
	//show methods:
	public Employee retreiveEmployeeById(int id){

		return employeeService.getEmployeeById(id);
	}
	
	
	public Employee retrieveEmployeeByEmail(String email) {

		return employeeService.getEployeeByEmail(email);
	}
	
	
	public Employee retrieveEmployeeByUsername(String username) {
		return employeeService.getEmployeeByUsername(username);
	}
	
	//create. Adds an employee to the employees table in database via service then dao layers
	public boolean registerEmployee(Employee employee) {
		
		EmployeeService employeeService = new EmployeeService();
		boolean success = false;
		employeeService.addEmployee(employee);
		
		return success;
	}
	
//	public void viewPastTickets() {
//		
//	}
//	
//	public void viewPendingRequest() {
//		
//	}
	
	//update
	//destroy

}
