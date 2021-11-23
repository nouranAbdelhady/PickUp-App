package RideData;

import java.util.List;

import Account.IAccount;
import Ride.Ride;

public class SaveAsDatabase extends RideService{
	
	//databaseObject
	//will assume that the type is String for now, later will change to database
	
	SaveAsDatabase(){
		System.out.println("New Ride database created");
	}

	@Override
	public void addData(Ride newRide) {
		System.out.println("Adding ride data to database");
		//databaseObject.save()
	}

	@Override
	public void removeData(Ride toRemove) {
		System.out.println("Removing ride data from database");
	}

	//should return database?
	@Override
	public List<Ride> getData() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
