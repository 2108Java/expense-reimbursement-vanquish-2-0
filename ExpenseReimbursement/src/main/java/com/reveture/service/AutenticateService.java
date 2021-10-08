package com.reveture.service;

import com.revature.DAO.RequestDAOImp;
import com.revature.Models.EmployeeRequest;

public class AutenticateService {
	public AutenticateService(RequestDAOImp requestDao) {
		this.requestDao= requestDao;
	}
	
	EmployeeRequest e= new EmployeeRequest();
	RequestDAOImp requestDao;
	public boolean verify(String email) {
		EmployeeRequest e= requestDao.selectByEmail(email);
		boolean employeeExists = false;
		if(e != null) {
			employeeExists = true;
		}
		
		return employeeExists;
		
		
	}
	public boolean authenticate(String email, String password) {

		boolean userExists = this.verify(email); //check if the user exists first
		boolean authenticated = false;
		if(userExists) {
			EmployeeRequest e = requestDao.selectByEmail(email);
			
			if(e.getEmail().equals(email)) {
				
				authenticated = true;
				
			}
		}
		
		return authenticated;
	}


}
