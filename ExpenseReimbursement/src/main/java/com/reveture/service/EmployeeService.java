package com.reveture.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.Models.ReimbursementRequest;

public class EmployeeService {
	private List<ReimbursementRequest> employee= new ArrayList<>();
	
	public EmployeeService() {
		
	}

	public ReimbursementRequest getEmployeeById(int position) throws IndexOutOfBoundsException{
		// TODO Auto-generated method stub
		return employee.get(position);
	}

}
