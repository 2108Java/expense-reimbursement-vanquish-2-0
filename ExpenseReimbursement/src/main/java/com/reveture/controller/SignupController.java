package com.reveture.controller;

import java.util.List;

import com.revature.DAO.SignupDAO;
import com.revature.DAO.SignupDAOImp;
import com.revature.Models.SignUp;
import com.reveture.service.SignupService;

public class SignupController {
	SignupDAOImp se= new SignupDAOImp();
	SignupService ss= new SignupService(se);
	
	public SignupController(SignupDAOImp s,SignupService ss ) {
		this.se=se;
		this.ss=ss;
	}
	
	public List<SignUp> seeAll(){
		
		
		return ss.seeAll();
	}
	
}
