package com.example.demo.Extra;

import com.example.demo.Entities.Driver;
import com.example.demo.Entities.Notification;
import com.example.demo.Entities.Passenger;
import com.example.demo.Entities.Ride;

public interface Subject2 {
	public boolean subscribePassenger( Passenger newSubscription);
	public void notifyObservers(Notification newNotification );
}
