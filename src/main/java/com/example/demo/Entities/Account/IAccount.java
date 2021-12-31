package com.example.demo.Entities.Account;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entities.Ride.Ride;
import com.example.demo.Extra.Observer2;
import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class IAccount implements Observer2{
	
	protected String type;
	protected String username;
	protected String password;
	protected Boolean isVerified;
	protected String email;
	private int mobileNumber;
	protected Boolean isLoggedIn;
	
	@JsonIgnore
	private Ride currentRide = null;
	@JsonIgnore
	private List<Ride> previousRides = new ArrayList<Ride>();
	
	@JsonIgnore
	private List<Notification> notifications;
	
	IAccount(){	
	}
	IAccount(String username,String password,String email){
		this.username=username;
		this.password=password;
		this.email=email;
		this.isLoggedIn=false;
		this.isVerified=true;
		this.type="Passenger";	//default is passenger
		this.notifications = new ArrayList<Notification>();
	}
	IAccount(String username,String password){
		this.username=username;
		this.password=password;
		this.isLoggedIn=false;
		this.isVerified=true;
		this.type="Passenger";	//default is passenger
		this.notifications = new ArrayList<Notification>();
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public Boolean getIsVerified() {
		return isVerified;
	}
	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Boolean getIsLoggedIn() {
		return isLoggedIn;
	}
	public void setIsLoggedIn(Boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	public List<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}		
	@Override
	public void getNotified(Notification newNotification) {
		 System.out.println(newNotification);
		 this.getNotifications().add(newNotification);	
	}
	public Ride getCurrentRide() {
		return currentRide;
	}
	public void setCurrentRide(Ride currentRide) {
		this.currentRide = currentRide;
	}
	public List<Ride> getPreviousRides() {
		return previousRides;
	}
	public void setPreviousRides(List<Ride> previousRides) {
		this.previousRides = previousRides;
	}	
}
