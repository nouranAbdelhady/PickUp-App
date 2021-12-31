package com.example.demo.Repositories.Account;

import java.util.List;

import com.example.demo.Entities.Account.Notification;
import com.example.demo.Entities.Account.Passenger;
import com.example.demo.Entities.Ride.Ride;

public class PassengerDatabaseRepo implements PassengerRepository{

	//database obj
	
	@Override
	public List<Passenger> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Passenger getPassenger(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addPassenger(Passenger newPassenger) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Notification> getNotifications(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deletePassenger(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Ride getRequestedRide(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ride getCurrentRide(Passenger targetedPassenger) {
		// TODO Auto-generated method stub
		return null;
	}	
	
	
}
