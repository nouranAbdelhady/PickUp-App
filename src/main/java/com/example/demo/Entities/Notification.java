package com.example.demo.Entities;

public class Notification {

	private static int notificationNumber=0;
	private IAccount from;
	private String message;
	
	public int getNotificationNumber() {
		return notificationNumber;
	}
	public void setNotificationNumber(int notificationNumber) {
		Notification.notificationNumber = notificationNumber;
	}
	public IAccount getFrom() {
		return from;
	}
	public void setFrom(IAccount from) {
		this.from = from;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Notification(int notificationNumber, IAccount from, String message) {
		super();
		Notification.notificationNumber = notificationNumber;
		this.from = from;
		this.message = message;
	}
	public Notification(IAccount from, String message) {
		super();
		Notification.notificationNumber++;
		this.from = from;
		this.message = message;
	}
	public Notification() {
		
	}
	public Notification(String message) {
		super();
		Notification.notificationNumber++;
		this.from = null;
		this.message = message;
	}
	
}
