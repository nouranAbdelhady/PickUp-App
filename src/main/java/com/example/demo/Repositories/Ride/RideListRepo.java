package com.example.demo.Repositories.Ride;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entities.Account.Notification;
import com.example.demo.Entities.Ride.Offer;
import com.example.demo.Entities.Ride.Rate;
import com.example.demo.Entities.Ride.Ride;

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

    //changed
    @Override
	public boolean addOffer(Ride toUpdate, Offer newOffer) {
    	
    	//get ride in repo
    	
    	//Ride ride = get(toUpdate.getRideId());
    	
    	//if(ride!=null) {
    		toUpdate.getOffers().add(newOffer);
    		//ride.getOffers().add(newOffer);
            
            Notification newNotification = new Notification("Driver with username: "+newOffer.getSuggestedBy().getUsername()+" offered price: "+newOffer.getPrice());
            toUpdate.subscribePassenger(toUpdate.getRequestedBy());
            
            toUpdate.notifyObserversWithNewOffer(newNotification);
			//toUpdate.getRequestedBy().getNotified(newNotification);
            return true;
    	//}
    	
		//return false;
	}

	@Override
	public List<Offer> getOffers(int rideId) {
		Ride targetedRide = this.get(rideId);
		return targetedRide.getOffers();
	}

	@Override
	public boolean acceptOffer(Ride toStart, Offer acceptedOffer) {
		for (Ride ride : allRides) {
            if (ride.getRideId() == toStart.getRideId()) {
            	//remove all offers and only keep the accepted one
            	ride.getOffers().clear();
                ride.getOffers().add(acceptedOffer);
                               
                //start ride
                ride.setActive(true);
                ride.setCost(acceptedOffer.getPrice());
                ride.setCurrentDriver(acceptedOffer.getSuggestedBy());         
              
                toStart.subscribeStart(acceptedOffer.getSuggestedBy());		//driver
                toStart.subscribeStart(toStart.getRequestedBy());		//passenger
                
                toStart.notifyObserversWithAcceptOffer(toStart);
                                
                return true;
            }
        }
		return false;
	}

	@Override
	public String endRide(Ride toEnd) {
		for (Ride ride : allRides) {
            if (ride.getRideId() == toEnd.getRideId()) {
            	
            	toEnd.setActive(false);
            	toEnd.notifyObserversWithEnd(toEnd);
                                
                return "Ride ended";
            }
        }
		return "Error: could not end ride";
	}

	@Override
	public Rate getRate(Ride targetedRide) {
		return targetedRide.getRate();
	}

	@Override
	public boolean addRate(Ride targetedRide, Rate newRate) {
		for (Ride ride : allRides) {
            if (ride.getRideId() == targetedRide.getRideId()) {
            	if(ride.getRate()==null) {
            		ride.setRate(newRate);
                	System.out.println("Rate added");
                    return true;
            	}
            	else {
            		return false;
            	}
            }
        }
        return false;
	}

}