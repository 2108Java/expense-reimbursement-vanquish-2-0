package com.revature.models;

import com.revature.service.EmployeeService;

public class Request {
	//a request cannot exist on its own, therefore, employee info should be present at the time of request creation. 
	EmployeeService employeeService = new EmployeeService();
    
    int requestId;
    String requestType; 
    double amount; 
    String description; 
    String requestStatus = "pending"; 
    String requestDate;
    int employeeId;
    
    
    public Request(int requestId, String requestType, double amount, String description, String requestStatus,
            String requestDate, int employeeId) {
        super();
        this.requestId = requestId;
        this.requestType = requestType;
        this.amount = amount;
        this.description = description;
        this.requestStatus = requestStatus;
        this.requestDate = requestDate;
        this.employeeId =  employeeId;  // must match the employee id in the database
    }
    
    public Request(String requestType, double amount, String description, String requestStatus, String requestDate) {
    	
    	this.requestType = requestType;
        this.amount = amount;
        this.description = description;
        this.requestStatus = requestStatus;
        this.requestDate = requestDate;
	}

	public int getEmployeeId() {
    	return employeeId;
    }
    
    public int getRequestId() {
        return requestId;
    }
    
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
    
    
    
    public String getRequestType() {
        return requestType;
    }
    
    public void setRequestType(String requestType) {
        this.requestType = requestType;
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
    
    public String getRequestStatus() {
        return requestStatus;
    }
    
    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }
    
    public String getRequestDate() {
        return requestDate;
    }
    
    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    @Override
    public String toString() {
        return "Request [requestd=" + requestId + ", requestType=" + requestType + ", amount=" + amount
                + ", description=" + description + ", requestStatus=" + requestStatus + ", requestDate="
                + requestDate + "]";
    } 
    
    
    
    

}
