package com.example.demo.Services.Account;

import java.util.List;

import com.example.demo.Entities.Driver;
import com.example.demo.Entities.FavoriteArea;
import com.example.demo.Entities.Notification;
import com.example.demo.Entities.Ride;
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
	public List<Notification> getNotifications(Driver targetedDriver) {
		return repository.getNotifications(targetedDriver);
	}

	@Override
	public boolean delete(String username) {
		return repository.deleteDriver(username);
	}

	@Override
	public boolean update(Driver toUpdate, FavoriteArea newArea) {
		return repository.update(toUpdate , newArea);
	}

	@Override
	public List<FavoriteArea> getFavoriteAreas(Driver targetedDriver) {
		return repository.getFavoriteAreas(targetedDriver);
	}

	@Override
	public List<Ride> getavaliableRides(Driver targetedDriver) {
		return repository.getavaliableRides(targetedDriver);
	}
	
	@Override
	public List<Driver> getPendingDrivers() {
		return repository.getPendingDrivers();
	}

	@Override
	public Driver getSinglePending(String username) {
		return repository.getSinglePending(username);
	}

	@Override
	public boolean updateVerify(Driver targetedDriver) {
		return repository.updateVerify(targetedDriver);
	}
}
