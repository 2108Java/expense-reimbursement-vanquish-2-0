package com.revature.repo;

import io.javalin.http.Context;

public interface UserDAO {


	public boolean getLogin(String username, String password);
	
}
