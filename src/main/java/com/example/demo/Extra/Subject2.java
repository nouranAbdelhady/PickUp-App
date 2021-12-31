package com.example.demo.Extra;

import com.example.demo.Entities.Account.IAccount;
import com.example.demo.Entities.Account.Notification;
import com.example.demo.Entities.Account.Passenger;
import com.example.demo.Entities.Ride.Ride;

public interface Subject2 {
	public boolean subscribePassenger( Passenger newSubscription );
	public void notifyObserversWithNewOffer(Notification newNotification);
	
	public void subscribeStart(IAccount newSubscription);
	public void notifyObserversWithAcceptOffer( Ride accepted );
	
}
