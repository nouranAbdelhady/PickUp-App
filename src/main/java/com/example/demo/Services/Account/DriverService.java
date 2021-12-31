package com.example.demo.Services.Account;

import java.util.List;

import com.example.demo.Entities.Driver;
import com.example.demo.Entities.Notification;
import com.example.demo.Repositories.Account.DriverListRepo;
import com.example.demo.Repositories.Account.DriverRepository;

public class DriverService implements IDriverService {
    private static DriverRepository repository;
    
    public DriverService (){
    	repository = new DriverListRepo();
    }

    @Override
    public List<Driver> getAll() {
        return repository.getAll();
    }

	@Override
	public Driver getDriver(String username) {
		return repository.getDriver(username);
	}

	@Override
	public boolean add(Driver newDriver) {
		return repository.addDriver(newDriver);
	}

	@Override
	public List<Notification> getNotifications(String username) {
		return repository.getNotifications(username);
	}

	@Override
	public boolean delete(String username) {
		return repository.deleteDriver(username);
	}

}
