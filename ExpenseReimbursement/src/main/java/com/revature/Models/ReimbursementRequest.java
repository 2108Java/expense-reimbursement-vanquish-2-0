package com.revature.Models;

public class ReimbursementRequest {
	private enum reimbursementType{
		LODGING, TRAVEL, FOOD, OTHER
		
	}
	private enum Status{
		AAPROVED, REJECTED, PENDING
	}
	
	private ReimbursementRequest rtype;
	private Status status= Status.PENDING;
	
	//private int id;
	private String email;
	private String description;
	
	private String timeOfRequest;
	private double amount;
	
	public Status getStatus() {
		return status;
	}
	public ReimbursementRequest getReimbursementRequest() {
		return rtype;
	}
	public String getEmail() {
		return email;
	}
	public Status setStatus(Status status) {
		return this.status=status;
	}
	public ReimbursementRequest setReimbursementRequest(ReimbursementRequest rtype) {
		return this.rtype=rtype;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	
	public ReimbursementRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReimbursementRequest(ReimbursementRequest rtype, Status status, String email, String description,
			String timeOfRequest, double amount) {
		super();
		this.rtype = rtype;
		this.status = status;
		this.email = email;
		this.description = description;
		this.timeOfRequest = timeOfRequest;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "ReimbursementRequest [rtype=" + rtype + ", status=" + status + ", email=" + email + ", description="
				+ description + ", timeOfRequest=" + timeOfRequest + ", amount=" + amount + "]";
	}
	
	
	
	


}
