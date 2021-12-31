package com.example.demo.Entities;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Extra.Observer2;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Passenger extends IAccount implements Observer2{
	
	@JsonIgnore
	protected List<Ride> previousRides;
	
	@JsonIgnore
	protected Ride requestedRide = null;
	
	public Ride getRequestedRide() {
		return requestedRide;
	}

	public void setRequestedRide(Ride requestedRide) {
		this.requestedRide = requestedRide;
	}

	public List<Ride> getPreviousRides() {
		return previousRides;
	}

	public void setPreviousRides(List<Ride> previousRides) {
		this.previousRides = previousRides;
	}

	public Passenger(String username, String password , String email , int mobileNumber){
		this.username = username;
		this.password = password;
		this.email = email;
		this.setMobileNumber(mobileNumber);
		this.isLoggedIn = false;
		this.isVerified = true;
		this.type = "Passenger";
		this.setNotifications( new ArrayList<Notification>() );
		this.previousRides = new ArrayList<Ride>();
	}
	
	Passenger(){
		this.setNotifications( new ArrayList<Notification>() );
		this.previousRides = new ArrayList<Ride>();
		this.isLoggedIn = false;
		this.isVerified = true;
		this.type = "Passenger";
	}

	@Override
	public void getNotified(Notification newNotification) {
		 System.out.println(newNotification);
		 this.getNotifications().add(newNotification);	
	}
	
}
