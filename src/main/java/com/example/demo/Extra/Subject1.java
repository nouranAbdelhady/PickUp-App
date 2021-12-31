package com.example.demo.Extra;

import com.example.demo.Entities.Account.Driver;
import com.example.demo.Entities.Account.Notification;
import com.example.demo.Entities.Ride.Ride;

public interface Subject1 {
	public boolean subscribeDriver(Driver newSubscription);
	public void notifyObservers(Notification newNotification, Ride newRide);
}
