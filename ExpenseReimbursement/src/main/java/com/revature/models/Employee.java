package com.revature.models;

public class Employee {
	
	private int id;
	private String employeeUsername;
	private String employeePassword;
	
	
	public Employee(int id, String employeeUsername, String employeePassword) {
		super();
		this.id = id;
		this.employeeUsername = employeeUsername;
		this.employeePassword = employeePassword;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmployeeUsername() {
		return employeeUsername;
	}


	public void setEmployeeUsername(String employeeUsername) {
		this.employeeUsername = employeeUsername;
	}


	public String getEmployeePassword() {
		return employeePassword;
	}


	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
