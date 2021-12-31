package com.example.demo.Services.Account;

import java.util.List;

import com.example.demo.Entities.*;

public interface IDriverService {
    public List<Driver> getAll();
	public Driver getDriver(String username);
	public boolean add(Driver newDriver);
	public List<Notification> getNotifications(Driver targetedDriver);
	public boolean delete(String username);	
	public boolean update(Driver toUpdate , FavoriteArea newArea) ;
	public List<FavoriteArea> getFavoriteAreas(Driver targetedDriver);
	public List<Ride> getavaliableRides(Driver targetedDriver);
	List<Driver> getPendingDrivers();
	public Driver getSinglePending(String username);
	public boolean updateVerify(Driver targetedDriver);
	public Ride getCurrentRide(Driver targetedDriver);
	public void updateAvaliableRides(Ride accepted);
}
