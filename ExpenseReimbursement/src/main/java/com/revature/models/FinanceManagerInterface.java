package com.revature.models;

public interface FinanceManagerInterface {
	
	
	public void login();
	
	public boolean processRequest();
	
	public void viewAllRequests();
	
	public void viewPendingRequests();
	
	public void logout();
	
	public void filterRequest();
}