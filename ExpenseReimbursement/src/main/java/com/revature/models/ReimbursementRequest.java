package com.revature.models;

public class ReimbursementRequest {
	
	private int id;
	private String reimbursementType;
	private double amount;
	private String description;
	private String status;
	private String timeOfRequest;
	private String username;
	
	public ReimbursementRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimbursementRequest(int id, String reimbursementType, double amount, String description, String status,
			String timeOfRequest, String username) {
		super();
		this.id = id;
		this.reimbursementType = reimbursementType;
		this.amount = amount;
		this.description = description;
		this.status = status;
		this.timeOfRequest = timeOfRequest;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
