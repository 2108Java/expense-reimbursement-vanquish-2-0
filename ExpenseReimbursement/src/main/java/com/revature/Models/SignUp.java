package com.revature.Models;

public class SignUp {
	private String first_name;
	private String last_name;
	private String email;
	private double contact;
	private String password;
	private String confirmed_password;
	
	
	public SignUp() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public double getContact() {
		return contact;
	}


	public void setContact(double contact) {
		this.contact = contact;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getConfirmed_password() {
		return confirmed_password;
	}


	public void setConfirmed_password(String confirmed_password) {
		this.confirmed_password = confirmed_password;
	}


	public SignUp(String first_name, String last_name, String email, double contact, String password,
			String confirmed_password) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.contact = contact;
		this.password = password;
		this.confirmed_password = confirmed_password;
	}
	

}
