package com.example.demo.Entities;

public class Notification {
	
	private static int counter = 0;
	private int notificationNumber;
	private String message;
	
	public int getNotificationNumber() {
		return notificationNumber;
	}
	public void setNotificationNumber(int notificationNumber) {
		this.notificationNumber = notificationNumber;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Notification(IAccount from, String message) {
		super();
		Notification.counter++;
    	this.setNotificationNumber(Notification.counter);
		this.message = message;
	}
	
	public Notification() {	
	}
	public Notification(String message) {
		super();
		Notification.counter++;
    	this.setNotificationNumber(Notification.counter);
		this.message = message;
	}
	
}
