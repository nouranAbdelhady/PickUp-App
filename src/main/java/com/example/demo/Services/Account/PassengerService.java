package com.example.demo.Services.Account;

import java.util.List;

import com.example.demo.Entities.Notification;
import com.example.demo.Entities.Passenger;
import com.example.demo.Repositories.Account.PassengerListRepo;
import com.example.demo.Repositories.Account.PassengerRepository;

public class PassengerService implements IPassengerService {
    private static PassengerRepository passengerRepo;
    
    public PassengerService (){
    	passengerRepo = new PassengerListRepo();
    }

    @Override
    public List<Passenger> getAll() {
        return passengerRepo.getAll();
    }

	@Override
	public Passenger getPassenger(String username) {
		return passengerRepo.getPassenger(username);
	}

	@Override
	public boolean add(Passenger newPassenger) {
		return passengerRepo.addPassenger(newPassenger);
	}

	@Override
	public List<Notification> getNotifications(String username) {
		return passengerRepo.getNotifications(username);
	}

	@Override
	public boolean delete(String username) {
		return passengerRepo.deletePassenger(username);
	}


}
