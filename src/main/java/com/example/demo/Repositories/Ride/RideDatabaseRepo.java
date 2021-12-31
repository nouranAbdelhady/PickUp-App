package com.example.demo.Repositories.Ride;

import java.util.List;
import com.example.demo.Entities.*;

public class RideDatabaseRepo implements RideRepository {

	//database object

	@Override
	public boolean add(Ride ride) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Ride get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ride> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Ride toUpdate, Offer newOffer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Offer getOffer(int rideId, int offerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offer> getOffers(int rideId) {
		// TODO Auto-generated method stub
		return null;
	}
		

}