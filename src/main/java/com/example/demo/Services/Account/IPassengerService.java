package com.example.demo.Services.Account;

import java.util.List;

import com.example.demo.Entities.*;

public interface IPassengerService {
    public List<Passenger> getAll();
	public Passenger getPassenger(String username);
	public boolean add(Passenger newPassenger);
	public List<Notification> getNotifications(String username);
	public boolean delete(String username);	
}
