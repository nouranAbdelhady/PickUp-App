package com.example.demo.Extra;

import com.example.demo.Entities.IAccount;
import com.example.demo.Entities.Notification;
import com.example.demo.Entities.Passenger;
import com.example.demo.Entities.Ride;

public interface Subject2 {
	public boolean subscribePassenger( Passenger newSubscription );
	public void notifyObserversWithNewOffer(Notification newNotification);
	
	public void subscribeStart(IAccount newSubscription);
	public void notifyObserversWithAcceptOffer( Ride accepted );
	
}
