package com.revature.service;

public interface AuthenticateService {
	
	public void verify(String username);
	
	public boolean authenticate(String username, String password);

}
