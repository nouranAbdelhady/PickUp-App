package com.example.demo.Repositories.Account;

import java.util.List;

import com.example.demo.Entities.Notification;
import com.example.demo.Entities.Passenger;
import com.example.demo.Entities.Ride;

public interface PassengerRepository {
	
	public List<Passenger> getAll();
	public Passenger getPassenger(String username);
	public boolean addPassenger(Passenger newPassenger);
	public List<Notification> getNotifications(String username);
	public boolean deletePassenger(String username);
	public Ride getRequestedRide(String username);
	public Ride getCurrentRide(Passenger targetedPassenger);
	
}
