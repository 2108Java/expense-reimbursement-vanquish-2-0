package com.reveture.service;



import com.revature.DAO.RequestDAOImp;
import com.revature.DAO.SignupDAOImp;
import com.revature.DAO.UserDAO;
import com.revature.Models.EmployeeRequest;
import com.revature.Models.SignUp;
import com.revature.Models.User;

public class AutenticateService {
	UserDAO dao;
	SignUp e= new SignUp();
	RequestDAOImp requestDao;
	SignupDAOImp sign;
	
	public AutenticateService(UserDAO dao) {
		super();
		this.dao= dao;
	}
	public User getUser(String username) {
		
		User name=dao.selectByUsername(username);
		System.out.println(dao.selectByUsername(username));
		name.setUsername(username);
		return name;
	}
	
	
	public boolean verify(String username) {
		User u =  dao.selectByUsername(username);
;		System.out.println(u);
		boolean employeeExists = false;
		if(e != null) {
			employeeExists = true;
		}
		
		return employeeExists;
		
		
	}
	public boolean authenticate(String username, String password) {

		boolean userExists = this.verify(username); //check if the user exists first
		boolean authenticated = false;
		
			if(userExists) {
				User u= dao.selectByUsername(username);
				if(u.getUsername().equals(username)) {
					authenticated = true;
					
				}
			}
			
		
		
		return authenticated;
	}


}
