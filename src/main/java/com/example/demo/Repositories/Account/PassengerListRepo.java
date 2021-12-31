package com.example.demo.Repositories.Account;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entities.Notification;
import com.example.demo.Entities.Passenger;
import com.example.demo.Entities.Ride;

public class PassengerListRepo implements PassengerRepository{
	
	public static List<Passenger> allPassengers = new ArrayList<Passenger>(); 
	 
	public List<Passenger> getAll() {
		return PassengerListRepo.allPassengers;
	}

	@Override
	public Passenger getPassenger(String username) {
		for	(int i=0 ; i <allPassengers.size() ; i++) {
			if(allPassengers.get(i).getUsername().compareTo(username) == 0) {
				return allPassengers.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean addPassenger(Passenger newPassenger) {
		AccountListRepo.allRegistrants.add(newPassenger);
		return allPassengers.add(newPassenger);
	}

	@Override
	public List<Notification> getNotifications(String username) {
		for	(int i=0 ; i <allPassengers.size() ; i++) {
			if(allPassengers.get(i).getUsername().compareTo(username) == 0) {
				return allPassengers.get(i).getNotifications();
			}
		}
		return null;
	}

	@Override
	public boolean deletePassenger(String username) {
		for	(int i=0 ; i <allPassengers.size() ; i++) {
			if(allPassengers.get(i).getUsername().compareTo(username) == 0) {
				allPassengers.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public Ride getRequestedRide(String username) {
		for	(int i=0 ; i <allPassengers.size() ; i++) {
			if(allPassengers.get(i).getUsername().compareTo(username) == 0) {
				return allPassengers.get(i).getRequestedRide();
			}
		}
		return null;
	}

	@Override
	public Ride getCurrentRide(Passenger targetedPassenger) {
		return targetedPassenger.getCurrentRide();
	}
	
}
