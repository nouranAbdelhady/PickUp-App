package com.example.demo.Repositories.Account;

import java.util.List;

import com.example.demo.Entities.Driver;
import com.example.demo.Entities.FavoriteArea;
import com.example.demo.Entities.Notification;
import com.example.demo.Entities.Ride;

public interface DriverRepository {
	
	public List<Driver> getAll();
	public Driver getDriver(String username);
	public boolean addDriver(Driver newDriver);
	public List<Notification> getNotifications(String username);
	public boolean deleteDriver(String username);
	public boolean update(Driver toUpdate, FavoriteArea newArea);
	public List<FavoriteArea> getFavoriteAreas(String username);
	public List<Ride> getavaliableRides(String username);
	
}
