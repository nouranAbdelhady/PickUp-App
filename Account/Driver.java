package Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Ride.Offer;
import Ride.Ride;

public class Driver extends IAccount{
		
	public int license;
	public int nationalId;
	public List<String> favoriteAreas;
	
	public List<String> getFavoriteAreas() {
		return favoriteAreas;
	}
	
	public void setFavoriteAreas(List<String> favoriteAreas) {
		this.favoriteAreas = favoriteAreas;
	}
	
	public void addToFavoriteAreas(String newArea) {
		favoriteAreas.add(newArea);
		System.out.println(newArea + " successfully added in favorite areas");
	}

	public Driver(String username, String password , String email , int mobileNumber , int license , int nationalId){
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.isLoggedIn = false;
		this.isVerified = false;
		this.license = license;
		this.nationalId = nationalId;
		this.favoriteAreas = new ArrayList<String>();
		this.type = "Driver";
	}
	
	Driver(){
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
		System.out.println("Enter license number:");
		int license = input.nextInt();
		System.out.println("Enter national id number:");
		int nationalid = input.nextInt();
		
		Driver newAcc = new Driver(username,password,email,mobileNu,license,nationalid);
		
		input.nextLine();	//ignore enter
		
		System.out.println("Enter your favourite area:");
		String newArea = input.nextLine();
		newAcc.addToFavoriteAreas(newArea);
		int choice1;
		do {
			 System.out.println("1-Add one more favourite Area ");
			 System.out.println("2-Cancel ");
			 choice1 = input.nextInt();
			 
			 while(choice1>2 || choice1<0) {
				 System.out.println("Invalid choice, try again");
				 choice1 = input.nextInt();
			 }
			 
			 if(choice1==1)
			 {   
				 System.out.println("Enter the area:");
				 input.nextLine();	//ignore enter
				 
				 newArea = input.nextLine();
				 newAcc.addToFavoriteAreas(newArea);
			 }			 
		 }while(choice1!=2);
		
		input.nextLine();
		//input.close();
		return newAcc;
	}
	
	public Offer suggestPrice(Double newPrice) {
		Offer newOffer = new Offer(newPrice , this);
		return newOffer;
	}
	
	
}
