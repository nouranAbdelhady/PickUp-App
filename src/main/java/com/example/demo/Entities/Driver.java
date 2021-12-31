package com.example.demo.Entities;

import java.util.ArrayList;
import java.util.List;

public class Driver extends IAccount{
		
	protected int license;
	protected int nationalId;
	protected List<FavoriteArea> favoriteAreas;
	protected List<Ride> avaliableRides;
	protected double balance;

	public Driver(String username, String password , String email , int mobileNumber , int license , int nationalId){
		this.username = username;
		this.password = password;
		this.email = email;
		this.setMobileNumber(mobileNumber);
		this.isLoggedIn = false;
		this.isVerified = false;
		this.license = license;
		this.nationalId = nationalId;
		this.favoriteAreas = new ArrayList<FavoriteArea>();
		this.setNotifications( new ArrayList<Notification>() );
		this.type = "Driver";
	}

	public Driver(String username, String password , String email){
		this.username = username;
		this.password = password;
		this.email = email;
		this.favoriteAreas = new ArrayList<FavoriteArea>();
		this.setNotifications( new ArrayList<Notification>() );
		this.type = "Driver";
		this.isLoggedIn = false;
		this.isVerified = false;
	}

	Driver(){
		this.favoriteAreas = new ArrayList<FavoriteArea>();
		this.setNotifications( new ArrayList<Notification>() );
		this.type = "Driver";
		this.isLoggedIn = false;
		this.isVerified = false;
	}

}
