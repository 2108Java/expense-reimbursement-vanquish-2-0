package com.revature.Models;

import java.util.List;

public class EmployeeRequest  {
	private String email;
	private String reimbursment_type;
	private String description;
	private String status;
	private String time_of_request;
	private String amount;
	
	

	public EmployeeRequest(String email, String reimbursmtimeOfRequestent_type, String description, String status, String time_of_request,
			String amount) {
		super();
		this.email = email;
		this.reimbursment_type = reimbursment_type;
		this.description = description;
		this.status = status;
		this.time_of_request = time_of_request;
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
	public String getReimbursment_type() {
		return reimbursment_type;
	}
	public void setReimbursment_type(String reimbursment_type) {
		this.reimbursment_type = reimbursment_type;
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
		return time_of_request;
	}
	public void setTimeOfRequest(String time_of_request) {
		this.time_of_request = time_of_request;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "EmployeeRequest [email=" + email + ", retype=" + reimbursment_type + ", description=" + description + ", status="
				+ status + ", timeOfRequest=" + time_of_request + ", amount=" + amount + "]";
	}

	
	
}
