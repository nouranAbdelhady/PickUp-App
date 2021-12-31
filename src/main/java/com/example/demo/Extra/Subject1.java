package com.example.demo.Extra;

import com.example.demo.Entities.Driver;
import com.example.demo.Entities.Notification;

public interface Subject1 {
	public boolean subscribeDriver(Driver newSubscription);
	public void notifyObservers(Notification newNotification);
}
