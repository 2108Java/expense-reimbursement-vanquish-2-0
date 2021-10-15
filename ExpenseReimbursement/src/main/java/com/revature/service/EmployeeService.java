package com.revature.service;

import com.revature.dao.EmployeeDao;
import com.revature.models.Employee;

public class EmployeeService {
	
	EmployeeDao employeeDao = new EmployeeDao();
	
	public int getEmployeeId(){
		
		return employeeDao.selectEmployeeId();
	}
	public String getEployeeEmail(){
		return employeeDao.selectEmployeeEmail();
	}
	
	public String getEmployeeUsername(){
		return employeeDao.selectEmployeeUsername();
	}
	
	public String getEmployeePassword(){
		return employeeDao.selectEmployeePassword();
	}
	
	public Employee getEmployeeById(int id) {
		return employeeDao.selectEmployeeById(id);
	}

}
