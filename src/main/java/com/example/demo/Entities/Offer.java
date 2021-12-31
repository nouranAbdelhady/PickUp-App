package com.example.demo.Entities;

public class Offer {
	private static int offerId;
	private double price;
	private boolean isAccepted;
	private Driver suggestedBy;
	
	public Offer(double price , Driver suggestedBy) {
		Offer.offerId++;
		this.price = price;
		this.isAccepted=false;
		this.suggestedBy=suggestedBy;
	}
	
	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		Offer.offerId = offerId;
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
