package com.example.demo.Entities.Account;

public class Notification {
	
	private String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Notification() {	
		this.message=null;
	}
	public Notification(String message) {
		super();
		this.message = message;
	}
	
}
