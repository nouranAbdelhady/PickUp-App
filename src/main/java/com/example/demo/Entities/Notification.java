package com.example.demo.Entities;

public class Notification {

	private static int notificationNumber=0;
	private String message;
	
	public int getNotificationNumber() {
		return notificationNumber;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Notification(IAccount from, String message) {
		super();
		Notification.notificationNumber++;
		this.message = message;
	}
	
	public Notification() {
		
	}
	public Notification(String message) {
		super();
		Notification.notificationNumber++;
		this.message = message;
	}
	
}
