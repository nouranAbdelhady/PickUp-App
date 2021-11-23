package Account;

import java.util.List;
import java.util.Scanner;

import Ride.Ride;

public class Passenger extends IAccount{
	
	
	public Passenger(String username, String password , String email , int mobileNumber){
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.isLoggedIn = false;
		this.isVerified = true;
		this.type = "Passenger";
	}
	
	Passenger(){
	}

	@Override
	public IAccount getDetails() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter username:");
		String username = input.nextLine();
		System.out.println("Enter password:");
		String password = input.nextLine();
		System.out.println("Enter email:");
		String email = input.nextLine();
		System.out.println("Enter mobile number:");
		int mobileNu = input.nextInt();
		
		IAccount newAcc = new Passenger(username,password,email,mobileNu);
		input.nextLine();
		//input.close();
		return newAcc;
	}
	
	public Ride requestRide(String source , String destination) {
		System.out.println("Request ride");
		Ride newRide = new Ride(source,destination,this);
		return newRide;
	}
	
	public void notifyDrivers(AccountManager accountManager, Ride requestedRide) {
		List<Driver> avaliableDrivers = accountManager.getAllDrivers();
		for (Driver singleDriver : avaliableDrivers) {
			  if(singleDriver.isVerified) {		//only notify verified
				  List<String> favAreas = singleDriver.getFavoriteAreas();
				  for(String favArea : favAreas) {
					  if(requestedRide.getSource().compareTo(favArea)==0) {
						  singleDriver.getNotified(requestedRide);
					  }
				  }
			  }  
		  }
		
	}
	
	
}
