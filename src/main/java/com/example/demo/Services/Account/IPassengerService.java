package com.example.demo.Services.Account;

import java.util.List;

import com.example.demo.Entities.Account.Notification;
import com.example.demo.Entities.Account.Passenger;
import com.example.demo.Entities.Ride.Ride;

public interface IPassengerService {
    public List<Passenger> getAll();
	public Passenger getPassenger(String username);
	public boolean add(Passenger newPassenger);
	public List<Notification> getNotifications(String username);
	public boolean delete(String username);
	public Ride getRequestedRide(String username);
	public Ride getCurrentRide(Passenger targetedPassenger);
	public List<Ride> getPreviousRides(Passenger targetedPassenger);	
}
