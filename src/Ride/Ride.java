package Ride;

import java.util.ArrayList;
import java.util.List;

import Account.Driver;
import Account.Passenger;

public class Ride {
	
	String source;
	public String destination;
	Passenger passenger;
	Driver driver;
	public List<Offer> offers;

	public Ride(String source, String destination, Passenger passenger) {
		this.source = source;
		this.destination = destination;
		this.passenger = passenger;
		this.driver = null;
		this.offers = new ArrayList<Offer>();
	}
	//setters & getters
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public List<Offer> getOffers() {
		return offers;
	}
	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	
	
}
