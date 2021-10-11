package com.reveture.service;

import com.revature.DAO.RequestDAOImp;
import com.revature.DAO.SignupDAOImp;
import com.revature.Models.EmployeeRequest;
import com.revature.Models.SignUp;

public class AutenticateService {
	public AutenticateService(SignupDAOImp sign) {
		this.sign=  sign;
	}
	
	SignUp e= new SignUp();
	RequestDAOImp requestDao;
	SignupDAOImp sign;
	public boolean verify(String email) {
		SignUp e= sign.selectByEmail(email);
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
			SignUp e = sign.selectByEmail(email);
			
			if(e.getEmail().equals(email)) {
				
				authenticated = true;
				
			}
		}
		
		return authenticated;
	}


}
