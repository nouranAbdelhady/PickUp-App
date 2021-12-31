package com.example.demo.Services.Ride;

import java.util.List;

import com.example.demo.Entities.*;
import com.example.demo.Repositories.Ride.RideListRepo;
import com.example.demo.Repositories.Ride.RideRepository;

public class RidesService implements IRidesService {
    private RideRepository rideRep = new RideListRepo();

    @Override
    public boolean add(Ride newRide) {
        return rideRep.add(newRide);
    }

    @Override
    public Ride get(int id) {
        return rideRep.get(id);
    }

    @Override
    public List<Ride> getAll() {
        return rideRep.getAll();
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }

	@Override
	public boolean update(Ride toUpdate, Offer newOffer) {
		return rideRep.update(toUpdate,newOffer);
	}

	@Override
	public Offer getOffer(int rideId, int offerId) {
		return rideRep.getOffer(rideId, offerId);
	}

}
