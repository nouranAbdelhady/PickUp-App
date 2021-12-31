package com.example.demo.Entities.Account;

import java.util.ArrayList;

import com.example.demo.Entities.Ride.Ride;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Passenger extends IAccount{
		
	@JsonIgnore
	protected Ride requestedRide = null;
	
	public Ride getRequestedRide() {
		return requestedRide;
	}

	public void setRequestedRide(Ride requestedRide) {
		this.requestedRide = requestedRide;
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
	}
	
	Passenger(){
		this.setNotifications( new ArrayList<Notification>() );
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
