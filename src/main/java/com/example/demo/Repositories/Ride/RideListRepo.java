package com.example.demo.Repositories.Ride;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entities.*;

public class RideListRepo implements RideRepository {

    private static List<Ride> allRides = new ArrayList<Ride>();

    @Override
    public boolean add(Ride ride) {
        return allRides.add(ride);
    }

    @Override
    public Ride get(int id) {
        for (Ride ride : allRides) {
            if (ride.getRideId() == id) {
                return ride;
            }
        }
        return null;
    }
    
    @Override
    public Offer getOffer(int rideId , int offerId) {
        for (Ride ride : allRides) {
            if (ride.getRideId() == rideId) {
            	for (Offer offer : ride.getOffers()) {
                    if (offer.getOfferId() == offerId) {
                    	return offer;
                    }
                }
            }
        }

        return null;
    }

    @Override
    public List<Ride> getAll() {
        return allRides;
    }

    @Override
    public boolean delete(int id) {
        for (Ride ride : allRides) {
            if (ride.getRideId() == id) {
                return allRides.remove(ride);
            }
        }
        return false;
    }

	@Override
	public boolean update(Ride toUpdate, Offer newOffer) {
		for (Ride ride : allRides) {
            if (ride.getRideId() == toUpdate.getRideId()) {
                ride.getOffers().add(newOffer);
                return true;
            }
        }
		return false;
	}

}