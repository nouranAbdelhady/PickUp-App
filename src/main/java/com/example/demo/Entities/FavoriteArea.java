package com.example.demo.Entities;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Extra.Subject1;

public class FavoriteArea implements Subject1{
	private String areaName;
	
	//Observer1/Subject1 Pattern
	List<Driver> driversWithFavoriteArea;

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
	public void notifyObservers(Notification newNotification) {
		for (Driver singleDriver : driversWithFavoriteArea) 
		{ 
		    singleDriver.getNotified(newNotification);
		}
	}

}