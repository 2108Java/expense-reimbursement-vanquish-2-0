package com.revature.models;

public class Manager  extends User implements FinanceManagerInterface{

	int manager_id;



	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(String username, String password, boolean isFinanceManager) {
		super(username, password, isFinanceManager);
		// TODO Auto-generated constructor stub
	}

	public Manager(int manager_id) {
		super();
		this.manager_id = manager_id;
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean processRequest() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void viewAllRequests() {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewPendingRequests() {
		// TODO Auto-generated method stub

	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}

	@Override
	public void filterRequest() {
		// TODO Auto-generated method stub

	}
}
