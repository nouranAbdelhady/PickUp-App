package com.example.demo.Repositories.Account;

import java.util.List;

import com.example.demo.Entities.Account.Driver;
import com.example.demo.Entities.Account.FavoriteArea;
import com.example.demo.Entities.Account.Notification;
import com.example.demo.Entities.Ride.Ride;

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
	public List<Notification> getNotifications(Driver targetedDriver) {
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
	public List<FavoriteArea> getFavoriteAreas(Driver targetedDriver) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Ride> getavaliableRides(Driver targetedDriver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Driver> getPendingDrivers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Driver getSinglePending(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateVerify(Driver targetedDriver) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Ride getCurrentRide(Driver targetedDriver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAvaliableRides(Ride accepted) {
		// TODO Auto-generated method stub
		
	}
	
	
}
