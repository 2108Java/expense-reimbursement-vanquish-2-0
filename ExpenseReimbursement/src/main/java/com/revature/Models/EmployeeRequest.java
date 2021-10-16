package com.revature.Models;

import java.util.List;

public class EmployeeRequest  {
	private int request_id;
	

	private String email;
	private String reimbursment_type;
	private String description;
	private String status;
	private String time_of_request;
	private String amount;
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
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
	public String getTime_of_request() {
		return time_of_request;
	}
	public void setTime_of_request(String time_of_request) {
		this.time_of_request = time_of_request;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public EmployeeRequest(int request_id, String email, String reimbursment_type, String description, String status,
			String time_of_request, String amount) {
		super();
		this.request_id = request_id;
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
	@Override
	public String toString() {
		return "EmployeeRequest [request_id=" + request_id + ", email=" + email + ", reimbursment_type="
				+ reimbursment_type + ", description=" + description + ", status=" + status + ", time_of_request="
				+ time_of_request + ", amount=" + amount + "]";
	}
	
	

	
	
}
