package com.example.demo.Repositories.Account;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entities.Driver;
import com.example.demo.Entities.Notification;

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
		for	(int i=0 ; i <allDrivers.size() ; i++) {
			if(allDrivers.get(i).getUsername().compareTo(username) == 0) {
				return allDrivers.get(i).getNotifications();
			}
		}
		return null;
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
	
}
