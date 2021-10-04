package com.revature.service;

import com.revature.models.User;

public interface UserService {
	
	public User getUserByUsername(String username);
	
	public void submitRequest(User user, ReimbursmentRequestInterface request);
}
