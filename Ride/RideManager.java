package Ride;

import java.util.ArrayList;
import java.util.List;

import RideData.Rides;

public class RideManager {
	Rides rides;
	
	public Ride currentRide = null;
	
	public RideManager() {
		rides = new Rides();
	}

	public List<Ride> getAllRides() {
		List<Ride> allRides = rides.savedData.getData();
		
		for (Ride singleRide : allRides) {
            System.out.println("Source: " + singleRide.source + " , Destination: " + singleRide.destination);
            for(int i=0 ; i<singleRide.offers.size() ; i++) {
            	 System.out.print( "Offer "+(i+1)+": " + singleRide.offers.get(i).price );
            	 System.out.print( " ( "+ singleRide.offers.get(i).suggestedBy.username + " )\n\n" );
            }
        }
		
		return allRides;
	}
	
	public List<Ride> getAllRidesWithSource(String targetedSource) {
		List<Ride> allRides = rides.savedData.getData();
		
		List<Ride> targetedRides = new ArrayList<Ride>();
		for (Ride singleRide : allRides) {
			if(singleRide.source.compareTo(targetedSource)==0) {
       		 	targetedRides.add(singleRide);       		 	
       	 	}
        }
		
		return targetedRides;
	}
	
	public void addRide(Ride newRide) {
		rides.savedData.addData(newRide);
		System.out.println( "New ride added" ); 
	}
	
	public void updateRide(Ride toUpdate , Offer newOffer) {
		toUpdate.offers.add(newOffer);
		System.out.println( "Ride updated" );
	}
	
}
