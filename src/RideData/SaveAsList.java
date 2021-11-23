package RideData;

import java.util.ArrayList;
import java.util.List;

import Account.IAccount;
import Ride.Ride;

public class SaveAsList extends RideService{
	
	public List<Ride> allRides;
	
	public SaveAsList(){
		this.allRides = new ArrayList<Ride>();
		System.out.println("New ride list created\n");
	}

	@Override
	public void addData(Ride newRide) {
		System.out.println("Adding ride data to list");
		this.allRides.add(newRide);
	}

	@Override
	public void removeData(Ride toRemove) {
		System.out.println("Removing ride data from list");
		this.allRides.remove(toRemove);
	}
	
	public List <Ride> getData() {
		System.out.println("Getting ride data from list");
		return this.allRides;
	}

}
