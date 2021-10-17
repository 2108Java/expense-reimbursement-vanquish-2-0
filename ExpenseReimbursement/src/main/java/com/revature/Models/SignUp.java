package com.revature.Models;

public class SignUp {
	private int employee_id;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	
	
	
	
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	
	
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public SignUp(int employee_id, String firstname, String lastname, String email, String phone) {
		super();
		this.employee_id = employee_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
	}
	public SignUp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "SignUp [employee_id=" + employee_id + ", firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", phone=" + phone + "]";
	}
	
	
	
	
	
}
