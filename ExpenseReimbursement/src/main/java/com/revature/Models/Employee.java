package com.revature.Models;

public class Employee extends Users implements EmployeeInterface{
	
	String firstname;
	String lastname;
	String email;
	String phone;
	
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String username, String password, boolean isFinanceManager) {
		super(username, password, isFinanceManager);
		// TODO Auto-generated constructor stub
	}

	public Employee(String firstname, String lastname, String email, String phone) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
	}

	@Override
	public void submitRequest() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkStatus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateInfo() {
		// TODO Auto-generated method stub
		
	}

}
