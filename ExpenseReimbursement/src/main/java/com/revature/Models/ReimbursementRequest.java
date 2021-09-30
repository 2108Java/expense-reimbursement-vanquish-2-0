package com.revature.Models;

public class ReimbursementRequest {
	
	//private int id;
	private String email;
	
	private String reimbursementType;
	private double amount;
	private String description;
	private String status;
	private String timeOfRequest;
	
	public ReimbursementRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReimbursementType() {
		return reimbursementType;
	}

	public void setReimbursementType(String reimbursementType) {
		this.reimbursementType = reimbursementType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
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

	public ReimbursementRequest(String email, String reimbursementType, double amount, String description,
			String status, String timeOfRequest) {
		super();
		this.email = email;
		this.reimbursementType = reimbursementType;
		this.amount = amount;
		this.description = description;
		this.status = status;
		this.timeOfRequest = timeOfRequest;
	}


}
