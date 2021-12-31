package com.example.demo.Entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Ride {
    private static int counter = 0;
    private int rideId;
    private String source;
    private String destination;
    
    @JsonIgnore
    private Passenger requestedBy;
    
    @JsonIgnore
    private List<Offer> offers;
    
    /*
    private String title;
    private String description;
    private double cost;
    private int rate;
    private int timeToLeave;
    
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
}
