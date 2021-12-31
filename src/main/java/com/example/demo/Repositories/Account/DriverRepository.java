package com.example.demo.Repositories.Account;

import java.util.List;

import com.example.demo.Entities.Account.Driver;
import com.example.demo.Entities.Account.FavoriteArea;
import com.example.demo.Entities.Account.Notification;
import com.example.demo.Entities.Ride.Ride;

public interface DriverRepository {
	
	public List<Driver> getAll();
	public Driver getDriver(String username);
	public boolean addDriver(Driver newDriver);
	public List<Notification> getNotifications(Driver targetedDriver);
	public boolean deleteDriver(String username);
	public boolean update(Driver toUpdate, FavoriteArea newArea);
	public List<FavoriteArea> getFavoriteAreas(Driver targetedDriver);
	public List<Ride> getavaliableRides(Driver targetedDriver);
	public List<Driver> getPendingDrivers();
	public Driver getSinglePending(String username);
	public boolean updateVerify(Driver targetedDriver);
	public Ride getCurrentRide(Driver targetedDriver);
	public void updateAvaliableRides(Ride accepted);
	
}
