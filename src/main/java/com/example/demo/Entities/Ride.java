package com.example.demo.Entities;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Extra.Subject2;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Ride implements Subject2{
    private static int counter = 0;
    private int rideId;
    private String source;
    private String destination;
    
    @JsonIgnore
    private Passenger requestedBy;
    
    @JsonIgnore
    private List<Offer> offers;
    
    //Observer2
    @JsonIgnore
    List<Passenger> Sub = new ArrayList<Passenger>();
    
    private int ETA;
    private double distance;
    
    /*
    private String title;
    private String description;
    private double cost;
    private int rate;
   
    
    private boolean isActive;
    private Driver currentDriver;
    */

    public Ride() {
    	this.offers = new ArrayList<Offer>();
    	Ride.counter++;
    	this.setRideId(Ride.counter);
    }

    public Ride(String source, String destination) {
        this.source = source;
        this.destination = destination;
        this.offers = new ArrayList<Offer>();
        this.setRideId(Ride.counter);
    }

    public String getSource() {
        return this.source;
    }

    public String getDestination() {
        return this.destination;
    }

	public Passenger getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(Passenger requestedBy) {
		this.requestedBy = requestedBy;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getRideId() {
		return rideId;
	}

	public void setRideId(int rideId) {
		this.rideId = rideId;
	}

	@Override
	public boolean subscribePassenger(Passenger newSubscription) {
		 Sub.add(newSubscription);
		return  true ;
	}

	@Override
	public void notifyObservers(Notification newNotification) {
		for ( Passenger p1 :  Sub) 
		{ 
			if(p1!=null) {
				 p1.getNotified(newNotification);
			}   
		}		
	}

	public int getETA() {
		return ETA;
	}

	public void setETA(int ETA) {
		this.ETA = ETA;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
}
