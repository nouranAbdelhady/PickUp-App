package com.example.demo.Repositories.Account;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entities.Driver;
import com.example.demo.Entities.FavoriteArea;
import com.example.demo.Entities.Notification;
import com.example.demo.Entities.Ride;

public class DriverListRepo implements DriverRepository{
	
	public static List<Driver> allDrivers = new ArrayList<Driver>(); 
	public static List<Driver> pendingDrivers; 
	 
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
	public List<Notification> getNotifications(Driver targetedDriver) {
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
	public List<FavoriteArea> getFavoriteAreas(Driver targetedDriver) {
		return targetedDriver.getFavoriteAreas();
	}

	@Override
	public List<Ride> getavaliableRides(Driver targetedDriver) {
		return targetedDriver.getAvaliableRides();
	}

	@Override
	public List<Driver> getPendingDrivers() {
		pendingDrivers = new ArrayList<Driver>();
		for	(int i=0 ; i <allDrivers.size() ; i++) {
			if(!allDrivers.get(i).getIsVerified()) {
				pendingDrivers.add(allDrivers.get(i));
			}
		}
		return pendingDrivers;
	}

	@Override
	public Driver getSinglePending(String username) {
		for	(int i=0 ; i <pendingDrivers.size() ; i++) {
			if(pendingDrivers.get(i).getUsername().compareTo(username)==0) {
				return pendingDrivers.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean updateVerify(Driver targetedDriver) {
		//remove from pending drivers list
		for	(int i=0 ; i <pendingDrivers.size() ; i++) {
			if(pendingDrivers.get(i).getUsername().compareTo(targetedDriver.getUsername())==0) {
				pendingDrivers.remove(i);
			}
		}
		
		//change isVerified to true
		for	(int i=0 ; i <allDrivers.size() ; i++) {
			if(allDrivers.get(i).getUsername().compareTo(targetedDriver.getUsername()) == 0) {
				allDrivers.get(i).setIsVerified(true);
				return true;
			}
		}
		return false;
	}

	@Override
	public Ride getCurrentRide(Driver targetedDriver) {
		return targetedDriver.getCurrentRide();
	}

	@Override
	public void updateAvaliableRides(Ride accepted) {
		for	(int i=0 ; i <allDrivers.size() ; i++) {
			allDrivers.get(i).getAvaliableRides().remove(accepted);
		}
	}
	
}
