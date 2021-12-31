package com.example.demo.Entities;

import java.util.ArrayList;
import java.util.List;

public class Passenger extends IAccount{
	
	protected List<Ride> previousRides;
	
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
	
}
