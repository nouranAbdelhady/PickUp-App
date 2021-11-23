package RideData;

import java.util.List;
import Account.IAccount;
import Ride.Ride;

public abstract class RideService {	
	
	public abstract void addData(Ride newRide);
	public abstract void removeData(Ride toRemove);
	
	//general?
	public abstract List<Ride> getData();
	
}