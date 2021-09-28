package com.revature.controllers;

public interface UserControllerInterface {
	

	//This is where I'm going to expose my data over HTTP
	// (Hyper Text Transfer protocol)
	
	//The plan is for the data to be represented to the user by 
	// my JavaScript, HTML and CSS.
	
public boolean authenticate(String username, String password);
	
	public void login();
	
	public void viewPendingRequest();
	
	public void viewPastRequests();
	
	public void RequestReinbursment();


}
