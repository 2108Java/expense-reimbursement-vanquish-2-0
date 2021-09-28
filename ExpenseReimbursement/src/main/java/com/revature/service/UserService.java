package com.revature.service;

import org.eclipse.jetty.server.Authentication.User;

public interface UserService {
	
	public void submitRequest(User user, ReimbursmentRequestInterface request);
}
