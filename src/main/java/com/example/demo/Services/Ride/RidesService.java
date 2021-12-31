package com.example.demo.Services.Ride;

import java.util.List;

import com.example.demo.Entities.Account.FavoriteArea;
import com.example.demo.Entities.Account.Notification;
import com.example.demo.Entities.Ride.Offer;
import com.example.demo.Entities.Ride.Rate;
import com.example.demo.Entities.Ride.Ride;
import com.example.demo.Repositories.Ride.RideListRepo;
import com.example.demo.Repositories.Ride.RideRepository;
import com.example.demo.Services.Area.AreaService;
import com.example.demo.Services.Area.IAreaService;

public class RidesService implements IRidesService{
    private RideRepository rideRep = new RideListRepo();
    private IAreaService areaService;
    
    public RidesService() {
    	areaService = new AreaService();
    }

    @Override
    public boolean add(Ride newRide) {
    	
    	String sourceRide = newRide.getSource();
    	System.out.println("Looking for: "+sourceRide);
    	FavoriteArea targetedArea = areaService.get(sourceRide);
    	
    	if(targetedArea!=null) {
    		System.out.println("Targeted area found "+targetedArea.getAreaName());
    	}
    	else{
    		System.out.println("Targeted area not found");
    	}

		Notification newNotification = new Notification("A new ride with id:" + newRide.getRideId()
				+ " is requested.");
		
		if(targetedArea!=null) {
			targetedArea.notifyObservers(newNotification , newRide);
		}
		
		//add ride to passenger [requestedRide]
		newRide.getRequestedBy().setRequestedRide(newRide);
		
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
	public boolean addOffer(Ride toUpdate, Offer newOffer) {
		return rideRep.addOffer(toUpdate,newOffer);
	}

	@Override
	public Offer getOffer(int rideId, int offerId) {
		return rideRep.getOffer(rideId, offerId);
	}

	@Override
	public List<Offer> getOffers(int rideId) {
		return rideRep.getOffers(rideId);
	}

	@Override
	public boolean acceptOffer(Ride toStart, Offer acceptedOffer) {
		return rideRep.acceptOffer(toStart,acceptedOffer);
	}

	@Override
	public String endRide(Ride toEnd) {
		return rideRep.endRide(toEnd);
	}

	@Override
	public Rate getRate(Ride targetedRide) {
		return rideRep.getRate(targetedRide);
	}

	@Override
	public boolean addRate(Ride targetedRide, Rate newRate) {
		return rideRep.addRate(targetedRide,newRate);
	}

}
