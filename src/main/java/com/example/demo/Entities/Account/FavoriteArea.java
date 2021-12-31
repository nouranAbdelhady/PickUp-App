package com.example.demo.Entities.Account;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entities.Ride.Ride;
import com.example.demo.Extra.Subject1;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class FavoriteArea implements Subject1{
	private String areaName;
	
	//Observer1/Subject1 Pattern
	@JsonIgnore
	List<Driver> driversWithFavoriteArea;

	public List<Driver> getDriversWithFavoriteArea() {
		return driversWithFavoriteArea;
	}
	public void setDriversWithFavoriteArea(List<Driver> driversWithFavoriteArea) {
		this.driversWithFavoriteArea = driversWithFavoriteArea;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public FavoriteArea(String areaName) {
		super();
		this.areaName = areaName;
		this.driversWithFavoriteArea = new ArrayList<Driver>();
	}
	public FavoriteArea() {
		this.driversWithFavoriteArea = new ArrayList<Driver>();
	}
	@Override
	public boolean subscribeDriver(Driver newSubscription) {
		return driversWithFavoriteArea.add(newSubscription);
	}
	@Override
	public void notifyObservers(Notification newNotification, Ride newRide) {
		for (Driver singleDriver : driversWithFavoriteArea) 
		{ 
			if(singleDriver!=null) {
				singleDriver.getNotified(newNotification);
			    singleDriver.getAvaliableRides().add(newRide);
			}   
		}
	}

}
