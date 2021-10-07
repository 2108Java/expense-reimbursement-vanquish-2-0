package com.reveture.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.DAO.RequestDAOImp;
import com.revature.Models.EmployeeRequest;
import com.revature.Models.ReimbursementRequest;

public class EmployeeService {
	
	
	private List<EmployeeRequest> employee= new ArrayList<>();
	RequestDAOImp re= new RequestDAOImp();
	EmployeeRequest e1 =new EmployeeRequest();
	
	public EmployeeService(RequestDAOImp re) {
		super();
		this.re=re;
		
		//initEmployee();
	}
	public void initEmployee() {
		//re.select();
	}

	public EmployeeRequest getEmployeeByEmail(String email) throws IndexOutOfBoundsException{
		// TODO Auto-generated method stub
		//e1 =re.select();
		 //employee=  re.selectByEmail();
		EmployeeRequest e1= re.selectByEmail(email);
		
		
		return e1;
	}
	public List <EmployeeRequest> seeAll() {
		List <EmployeeRequest> e1 =  re.select();
		
		return e1;
	}
	

}
