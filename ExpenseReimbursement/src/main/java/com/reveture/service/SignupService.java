package com.reveture.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.DAO.RequestDAOImp;
import com.revature.DAO.SignupDAOImp;
import com.revature.Models.EmployeeRequest;
import com.revature.Models.SignUp;

public class SignupService {
	SignUp signup= new SignUp();
	private List<SignUp> signup2= new ArrayList<>();
	SignupDAOImp se= new SignupDAOImp();
	
	public SignupService() {
		super();
		//this.se=se;
	}
public SignUp getEmployeeByEmail(String email) throws IndexOutOfBoundsException{
		
		signup=se.selectByEmail(email);
		
		return this.signup;
	}
	
	public List<SignUp> seeAll(){
		signup2=se.select();
		
		return signup2;
	}
	

}
