package com.example.demo.Repositories.Ride;

import java.util.List;

import com.example.demo.Entities.Ride.Offer;
import com.example.demo.Entities.Ride.Ride;

public interface RideRepository {

    boolean add(Ride ride);
    Ride get(int id);
    List<Ride> getAll();
    boolean delete(int id);
    public boolean addOffer(Ride toUpdate, Offer newOffer);
	public Offer getOffer(int rideId, int offerId);
	public List<Offer> getOffers(int rideId);
	public boolean acceptOffer(Ride toStart, Offer acceptedOffer);
	public String endRide(Ride toEnd);
	
}