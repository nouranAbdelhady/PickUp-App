package com.example.demo.Repositories.Account;

import java.util.List;

import com.example.demo.Entities.Driver;
import com.example.demo.Entities.FavoriteArea;
import com.example.demo.Entities.Notification;
import com.example.demo.Entities.Ride;

public class DriverDatabaseRepo implements DriverRepository{

	//databse obj
	
	@Override
	public List<Driver> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Driver getDriver(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addDriver(Driver newDriver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Notification> getNotifications(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteDriver(String username) {
		return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update(Driver toUpdate, FavoriteArea newArea) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<FavoriteArea> getFavoriteAreas(String username) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Ride> getavaliableRides(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
