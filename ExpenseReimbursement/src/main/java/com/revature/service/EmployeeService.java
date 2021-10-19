package com.revature.service;

import com.revature.dao.EmployeeDao;
import com.revature.models.Employee;

public class EmployeeService {
	
	EmployeeDao employeeDao = new EmployeeDao();
	
	public Employee getEmployeeById(int id){
		
		return employeeDao.selectEmployeeById(id);
	}
	public Employee getEployeeByEmail(String email){
		return employeeDao.selectEmployeeByEmail(email);
	}
	
	public Employee getEmployeeByUsername(String username){
		return employeeDao.selectEmployeeByUsername(username);
	}
	

	public boolean addEmployee(Employee employee) {
		boolean success = false;
		
		return success;
	}

}
