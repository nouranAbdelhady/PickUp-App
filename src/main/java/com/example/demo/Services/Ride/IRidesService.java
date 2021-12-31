package com.example.demo.Services.Ride;

import java.util.List;

import com.example.demo.Entities.Offer;
import com.example.demo.Entities.Ride;

public interface IRidesService {
    public boolean add(Ride newRide);
    public Ride get(int id);
    public List<Ride> getAll();
    public boolean delete(int id);
    public boolean addOffer(Ride toUpdate , Offer newOffer);
    public boolean acceptOffer(Ride toStart, Offer acceptedOffer);
	public Offer getOffer(int rideId, int offerId);
	public List<Offer> getOffers(int rideId);
}
