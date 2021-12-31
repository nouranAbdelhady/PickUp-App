package com.example.demo.Entities;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Extra.Observer1;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Driver extends IAccount implements Observer1 {
		
	protected int license;
	protected int nationalId;
	@JsonIgnore
	protected List<FavoriteArea> favoriteAreas; 
	@JsonIgnore
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
		this.avaliableRides = new ArrayList<Ride>();
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
		this.avaliableRides = new ArrayList<Ride>();
	}

	Driver(){
		this.favoriteAreas = new ArrayList<FavoriteArea>();
		this.setNotifications( new ArrayList<Notification>() );
		this.type = "Driver";
		this.isLoggedIn = false;
		this.isVerified = false;
		this.avaliableRides = new ArrayList<Ride>();
	}

	@Override
	public void getNotified(Notification newNotification) {
		this.getNotifications().add(newNotification);
	}

	public int getLicense() {
		return license;
	}

	public void setLicense(int license) {
		this.license = license;
	}

	public int getNationalId() {
		return nationalId;
	}

	public void setNationalId(int nationalId) {
		this.nationalId = nationalId;
	}

	public List<FavoriteArea> getFavoriteAreas() {
		return favoriteAreas;
	}

	public void setFavoriteAreas(List<FavoriteArea> favoriteAreas) {
		this.favoriteAreas = favoriteAreas;
	}

	public List<Ride> getAvaliableRides() {
		return avaliableRides;
	}
	
	public boolean addFavoriteAreas(FavoriteArea newArea) {
		return this.favoriteAreas.add(newArea);
	}

	public void setAvaliableRides(List<Ride> avaliableRides) {
		this.avaliableRides = avaliableRides;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
