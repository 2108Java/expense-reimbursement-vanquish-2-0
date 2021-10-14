package com.revature.models;

public class Request {
	
	int request_id;
	String request_type; 
	double amount; 
	String description; 
	String request_status = "pending"; 
	String request_date;
	public Request(int request_id, String request_type, double amount, String description, String request_status,
			String request_date) {
		super();
		this.request_id = request_id;
		this.request_type = request_type;
		this.amount = amount;
		this.description = description;
		this.request_status = request_status;
		this.request_date = request_date;
	}
	
	public int getRequest_id() {
		return request_id;
	}
	
	
	
	public String getRequest_type() {
		return request_type;
	}
	
	public void setRequest_type(String request_type) {
		this.request_type = request_type;
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
	
	public String getRequest_status() {
		return request_status;
	}
	
	public void setRequest_status(String request_status) {
		this.request_status = request_status;
	}
	
	public String getRequest_date() {
		return request_date;
	}
	
	public void setRequest_date(String request_date) {
		this.request_date = request_date;
	}

	@Override
	public String toString() {
		return "Request [request_id=" + request_id + ", request_type=" + request_type + ", amount=" + amount
				+ ", description=" + description + ", request_status=" + request_status + ", request_date="
				+ request_date + "]";
	} 
	
	
	
	

}
