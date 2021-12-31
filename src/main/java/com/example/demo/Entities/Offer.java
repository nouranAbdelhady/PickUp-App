package com.example.demo.Entities;

public class Offer {
	private static int counter = 0;
	private int offerId;
	private double price;
	private boolean isAccepted;
	private Driver suggestedBy;
	
	public Offer(double price , Driver suggestedBy) {
		Offer.counter++;
		this.offerId = counter;
		this.price = price;
		this.isAccepted=false;
		this.suggestedBy=suggestedBy;
	}
	
	public Offer() {
		Offer.counter++;
		this.offerId = counter;		
		this.isAccepted=false;
	}
	
	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isAccepted() {
		return isAccepted;
	}
	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	public Driver getSuggestedBy() {
		return suggestedBy;
	}
	public void setSuggestedBy(Driver suggestedBy) {
		this.suggestedBy = suggestedBy;
	}
	
}
