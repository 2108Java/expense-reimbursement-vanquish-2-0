package com.revature.models;

public class Users {
	
	private String username;
	private String password;
	private boolean isFinanceManager;
	
	public Users() {
		super();
		
	}

	public Users(String username, String password, boolean isFinanceManager) {
		super();
		this.username = username;
		this.password = password;
		this.isFinanceManager = isFinanceManager;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isFinanceManager() {
		return isFinanceManager;
	}

	public void setFinanceManager(boolean isFinanceManager) {
		this.isFinanceManager = isFinanceManager;
	}
	
	

}
