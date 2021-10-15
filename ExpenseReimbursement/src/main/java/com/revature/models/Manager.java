package com.revature.models;

public class Manager {
	
	int managerId;
	String mangerUsername;
	String managerPassword;
	
	public Manager(int managerId, String mangerUsername, String managerPassword) {
		super();
		this.managerId = managerId;
		this.mangerUsername = mangerUsername;
		this.managerPassword = managerPassword;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getMangerUsername() {
		return mangerUsername;
	}

	public void setMangerUsername(String mangerUsername) {
		this.mangerUsername = mangerUsername;
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	@Override
	public String toString() {
		return "managerList [managerId=" + managerId + ", mangerUsername=" + mangerUsername + ", managerPassword="
				+ managerPassword + "]";
	}
	
	

}
