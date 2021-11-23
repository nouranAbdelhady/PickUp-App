package Ride;

import Account.Driver;

public class Offer {
	
	public Double price;
	Boolean isAccepted;
	public Driver suggestedBy;
	public Offer(Double price, Driver suggestedBy) {
		this.price = price;
		this.isAccepted = false;
		this.suggestedBy = suggestedBy;
	}
	
}
