package com.example.demo.Repositories.Account;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entities.Driver;
import com.example.demo.Entities.FavoriteArea;
import com.example.demo.Entities.Notification;
import com.example.demo.Entities.Ride;

public class DriverListRepo implements DriverRepository{
	
	public static List<Driver> allDrivers = new ArrayList<Driver>(); 
	 
	public List<Driver> getAll() {
		return DriverListRepo.allDrivers;
	}

	@Override
	public Driver getDriver(String username) {
		for	(int i=0 ; i <allDrivers.size() ; i++) {
			if(allDrivers.get(i).getUsername().compareTo(username) == 0) {
				return allDrivers.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean addDriver(Driver newDriver) {
		AccountListRepo.allRegistrants.add(newDriver);
		return allDrivers.add(newDriver);
	}

	@Override
	public List<Notification> getNotifications(String username) {
		Driver targetedDriver = this.getDriver(username);		//get obj inside the repo
		return targetedDriver.getNotifications();
	}

	@Override
	public boolean deleteDriver(String username) {
		for	(int i=0 ; i <allDrivers.size() ; i++) {
			if(allDrivers.get(i).getUsername().compareTo(username) == 0) {
				allDrivers.remove(i);
				return true;
			}
		}
		return false;		
	}

	@Override
	public boolean update(Driver toUpdate, FavoriteArea newArea) {
		toUpdate = this.getDriver(toUpdate.getUsername());		//get obj inside the repo
		return toUpdate.addFavoriteAreas(newArea);
	}

	@Override
	public List<FavoriteArea> getFavoriteAreas(String username) {
		Driver targetedDriver = this.getDriver(username);		//get obj inside the repo
		return targetedDriver.getFavoriteAreas();
	}

	@Override
	public List<Ride> getavaliableRides(String username) {
		Driver targetedDriver = this.getDriver(username);		//get obj inside the repo
		return targetedDriver.getAvaliableRides();
	}
	
}
