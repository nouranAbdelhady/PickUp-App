package com.example.demo.Entities.Ride;

public class Rate {

	private int stars;
	private String feedback;
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Rate(int stars, String feedback) {
		super();
		this.stars = stars;
		this.feedback = feedback;
	}
	public Rate() {
		
	}
	
}
