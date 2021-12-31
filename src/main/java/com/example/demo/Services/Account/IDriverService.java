package com.example.demo.Services.Account;

import java.util.List;

import com.example.demo.Entities.*;

public interface IDriverService {
    public List<Driver> getAll();
	public Driver getDriver(String username);
	public boolean add(Driver newDriver);
	public List<Notification> getNotifications(String username);
	public boolean delete(String username);	
}
