package com.example.demo.Repositories.Ride;

import java.util.List;

import com.example.demo.Entities.*;

public interface RideRepository {

    boolean add(Ride ride);
    Ride get(int id);
    List<Ride> getAll();
    boolean delete(int id);
    public boolean update(Ride toUpdate, Offer newOffer);
	public Offer getOffer(int rideId, int offerId);
	public List<Offer> getOffers(int rideId);
	
}