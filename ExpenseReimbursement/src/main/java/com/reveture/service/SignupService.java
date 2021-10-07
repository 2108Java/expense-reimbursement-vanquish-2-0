package com.reveture.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.DAO.RequestDAOImp;
import com.revature.DAO.SignupDAOImp;
import com.revature.Models.SignUp;

public class SignupService {
	SignUp signup= new SignUp();
	private List<SignUp> signup2= new ArrayList<>();
	SignupDAOImp se= new SignupDAOImp();
	public SignupService(SignupDAOImp se) {
		super();
		this.se=se;
	}
	
	public List<SignUp> seeAll(){
		signup2=se.select();
		
		return signup2;
	}
	

}
