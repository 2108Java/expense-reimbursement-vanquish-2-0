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
	
	public EmployeeService() {
		super();
		//this.re=re;
		//initEmployee();
		
		//initEmployee();
	}
	/*public void initEmployee() {
		//re.select();
		List<EmployeeRequest> employee=re.selectByEmail();
	}*/

	public List <EmployeeRequest> getEmployeeByEmail() throws IndexOutOfBoundsException{
		
		List <EmployeeRequest>	employee=re.selectByEmail(e1);
		
		return this.employee;
	}
	public List <EmployeeRequest> seeAll() {
		List <EmployeeRequest> e1 =  re.select();
		
		return e1;
	}
	

}
