package com.reveture.controller;

public class Message {
private String information;
	
	

	public Message(String information) {
		super();
		this.information = information;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	@Override
	public String toString() {
		return "Message [information=" + information + "]";
	}
	
	

}
