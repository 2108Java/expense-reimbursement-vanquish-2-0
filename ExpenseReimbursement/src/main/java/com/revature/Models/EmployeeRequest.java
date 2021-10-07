package com.revature.Models;

public class EmployeeRequest {
	private String email;
	private String retype;
	private String description;
	private String status;
	private String timeOfRequest;
	private double amount;
	
	

	public EmployeeRequest(String email, String retype, String description, String status, String timeOfRequest,
			double amount) {
		super();
		this.email = email;
		this.retype = retype;
		this.description = description;
		this.status = status;
		this.timeOfRequest = timeOfRequest;
		this.amount = amount;
	}
	
	public EmployeeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRetype() {
		return retype;
	}
	public void setRetype(String retype) {
		this.retype = retype;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTimeOfRequest() {
		return timeOfRequest;
	}
	public void setTimeOfRequest(String timeOfRequest) {
		this.timeOfRequest = timeOfRequest;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "EmployeeRequest [email=" + email + ", retype=" + retype + ", description=" + description + ", status="
				+ status + ", timeOfRequest=" + timeOfRequest + ", amount=" + amount + "]";
	}

	
	
}
