import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Account.*;
import Admin.AdminManager;
import Ride.Offer;
import Ride.Ride;
import Ride.RideManager;

public class Demo {

	public static void main(String[] args) {
			
		Scanner input = new Scanner(System.in);
		Boolean systemLoop = true;
				
		AccountFactory accountFactory = new AccountFactory();
		AccountManager accountManager = new AccountManager();
		RideManager rideManager = new RideManager();
		
		//////////////	For testing		///////////////////
		IAccount driver1 = new Driver("driver1","password1","driver1@gmail.com",125,123,95);
		IAccount driver2 = new Driver("driver2","password2","driver2@gmail.com",125,456,95);
		IAccount driver3 = new Driver("driver3","password3","driver3@gmail.com",125,789,95);
		
		List<String> favArea1 = new ArrayList<String>(Arrays.asList("Giza","Maadi"));
		List<String> favArea2 = new ArrayList<String>(Arrays.asList("6 October","Giza"));
		List<String> favArea3 = new ArrayList<String>(Arrays.asList("Giza","6 October","Zamalek"));
		
		((Driver) driver1).setFavoriteAreas(favArea1);
		((Driver) driver2).setFavoriteAreas(favArea2);
		((Driver) driver3).setFavoriteAreas(favArea3);		
		
		IAccount passenger1 = new Passenger("passenger1","password1","driver1@gmail.com",123);
		IAccount passenger2 = new Passenger("passenger2","password2","driver2@gmail.com",124);
		IAccount passenger3 = new Passenger("passenger3","password3","driver3@gmail.com",125);
		
		accountManager.Register(driver1);
		accountManager.Register(driver2);
		accountManager.Register(driver3);
		  
		accountManager.Register(passenger1);
		accountManager.Register(passenger2);
		accountManager.Register(passenger3);
		
		System.out.println();
		//////////////////////////////////////////////////
		
		while(systemLoop) {
			System.out.println("1-Passenger");
			System.out.println("2-Driver");
			System.out.println("3-Admin");
			System.out.println("4-Exit");
			
			int accountChoice = input.nextInt();
			System.out.println();
			
			while (accountChoice>4 || accountChoice<1) {
				System.out.println("Invalid, try again");
				accountChoice = input.nextInt();
			}
			
			if (accountChoice==4) { break; }	//exit app [terminate]
			
			if (accountChoice==3) {	//admin (special case)
				while(true) {
					System.out.println("1-Get all registrants");
					System.out.println("2-Get all pending drivers");
					System.out.println("3-Get all currently logged in");
					System.out.println("4-Go Back");
					
					int adminChoice = input.nextInt();
					System.out.println();
					
					while (adminChoice>4 || adminChoice<1) {
						System.out.println("Invalid, try again");
						adminChoice = input.nextInt();
					}
					
					AdminManager adminManager = new AdminManager(accountManager);
					
					
					if(adminChoice==2) {	//pending drivers
						adminManager.getPendingDrivers();
						
						System.out.println("All done..");
						System.out.println("Returning to main menu..");
						System.out.println();
						continue;
					}
					else {
						if(adminChoice==1) {	//get ALL
							accountManager.getAllRegistrants();
							System.out.println();
							continue;
						}
						else {
							if(adminChoice==3) {	//get currently logged in
								adminManager.getAllLoggedIn();
								System.out.println();
								continue;
							}
						}
					}
					//else --> go back (4)
					break;
				}
				continue;	//return to 1st menu
			}
						
			//work on the current user [functions]
			Boolean userChoice = true;
			while(userChoice) {
				System.out.println("1-Register");
				System.out.println("2-Login");
				System.out.println("3-Go Back");
				
				int choice = input.nextInt();
				System.out.println();
				
				switch(choice) {
				  case 1:	//Register
					  System.out.println("Registeration:");
					  //based on the choice, will create User (1-->Passenger / 2-->Driver)
					  accountManager.currentUser = accountFactory.createAccount(accountChoice);
					  System.out.println();
					  accountManager.Register(accountManager.currentUser);
					  
					  //no break 3ashan ba3d el registration y-login
					  //break;
				  case 2:	//Login
					  System.out.println("Login:");
					  input.nextLine();
					  System.out.println("Enter username:");
					  String username = input.nextLine();
					  System.out.println("Enter password:");
					  String password = input.nextLine();
					  System.out.println();
					  
					  if(accountManager.Login(username, password)) {
						  //while loggedIn
						  if(accountManager.currentUser.type.compareTo("Driver")==0) {		//driver logged in

							  while(userChoice) {
								  System.out.println();
								  System.out.println("1-Add new favorite areas");
								  System.out.println("2-List avaliable rides");
								  System.out.println("3-Logout");
								  System.out.println("4-Go Back");
								  
								  int userFunctionChoice = input.nextInt();
								  System.out.println();
								  
								  switch(userFunctionChoice) {
								  case 1:	//Add new favorite areas
									  	input.nextLine();	//ignore 1
										System.out.println("Enter your new favourite area:");
										String newArea = input.nextLine();
										((Driver) accountManager.currentUser).addToFavoriteAreas(newArea);
										int choice1;
										do {
											System.out.println("1-Add one more favourite Area ");
											System.out.println("2-Cancel ");
											choice1 = input.nextInt();

											while (choice1 > 2 || choice1 < 0) {
												System.out.println("Invalid choice, try again");
												choice1 = input.nextInt();
											}

											if (choice1 == 1) {
												System.out.println("Enter the area:");
												input.nextLine(); // ignore enter

												newArea = input.nextLine();
												((Driver) accountManager.currentUser).addToFavoriteAreas(newArea);
											}
										} while (choice1 != 2);

										break;
								  case 2:	//List avaliable rides
									  //loop over all favorite aread
									  List<Ride> rides = new ArrayList<Ride>();
									  for(int i=0 ; i< ((Driver) accountManager.currentUser).favoriteAreas.size() ; i++) 	
									  {
										  //get rides with source = favorite area
									      String currentFavoriteArea = ((Driver) accountManager.currentUser).favoriteAreas.get(i);
										   List<Ride> subRides = rideManager.getAllRidesWithSource( currentFavoriteArea );
										   for(Ride subRide : subRides) {
												  rides.add(subRide);
										   }
									  }
									  
										for (int i = 0; i < rides.size(); i++) {
											
											System.out.println( (i+1) + " : Source: " + rides.get(i).getSource()+ " , Destination: " + rides.get(i).destination);
											for (int j = 0; j < rides.get(i).offers.size(); j++) {
												System.out.print("\t Offer " + (j + 1) + ": " + rides.get(i).offers.get(j).price);
												System.out.print("\t ( " + rides.get(i).offers.get(j).suggestedBy.username + " )\n");
											}
											System.out.println();
										}
									  
									  if(rides.size()!=0) {			//offer
										  do {
											  	System.out.println();
												System.out.println("1-Add offer to 1 of the rides ");
												System.out.println("2-Go back ");
												choice1 = input.nextInt();

												while (choice1 > 2 || choice1 < 0) {
													System.out.println("Invalid choice, try again");
													choice1 = input.nextInt();
												}

												input.nextLine(); // ignore enter
												if (choice1 == 1) {
													//add offer
													System.out.println("Choose 1 of the rides from above");
													int rideChoice = input.nextInt();
													
													Ride targetedRide = rides.get(rideChoice-1);
													
													input.nextLine(); // ignore enter
													//will use the index to access ride
													System.out.println("Enter offer price:");
													Double offerPrice = input.nextDouble();
													
													//call function that adds offer to ride
													Offer newOffer = ((Driver) accountManager.currentUser).suggestPrice(offerPrice);
													rideManager.updateRide(targetedRide, newOffer);	
													
													//notify passenger
													Passenger requestedBy = targetedRide.getPassenger();
													System.out.println();
													System.out.println(requestedBy.username + " is notified with the new price ["+ offerPrice +"]");
										
												}
											} while (choice1 != 2);
									  }
									  break;
								  case 3:	//Logout
									  accountManager.Logout();
									  userChoice = false;
									  break;
								  case 4:	//Go back (without logging out)
									  userChoice = false;
									  break;
								  default:
									 System.out.println("Invalid, try again!");
									 continue;
								  }
							  }
							  
						  }
						  else	//passenger logged in 
						  {

							  while(userChoice) {
								  System.out.println();
								  System.out.println("1-Request a ride");
								  System.out.println("2-Logout");
								  System.out.println("3-Go Back");
								  
								  int userFunctionChoice = input.nextInt();
								  System.out.println();
								  
								  input.nextLine();
								  switch(userFunctionChoice) {
								  case 1:	//Function 1
									  
									  System.out.println("Enter source: ");
									  String source = input.nextLine();
									  System.out.println("Enter destination");
									  String destination = input.nextLine();
									  Ride newRide = ((Passenger) accountManager.currentUser).requestRide(source, destination);
									  rideManager.addRide(newRide);
									  
									  //notify drivers
									  List<Driver> drivers = accountManager.getAllDrivers();
									  
									  System.out.println();
									  
									  for (Driver singleDriver : drivers) {
										  if(singleDriver.isVerified) {		//only notify verified
											  List<String> favAreas = singleDriver.getFavoriteAreas();
											  for(String favArea : favAreas) {
												  if(newRide.getSource().compareTo(favArea)==0) {
													  System.out.println(singleDriver.username +" is notified");
												  }
											  }
										  }  
									  }
									  
									  break;
								  case 2:	//Logout
									  accountManager.Logout();
									  userChoice = false;
									  break;
								  case 3:	//Go back (without logging out)
									  userChoice = false;
									  break;
								  default:
									 System.out.println("Invalid, try again!");
									 continue;
									}
								}
							}
						}
					  
					  break;
				  case 3:	//go back
						 userChoice = false;
						 break;
				  default:
					 System.out.println("Invalid, try again!");
					 continue;
				}
				
				System.out.println();
			}			
		}
		input.close();
		System.out.println("Exiting app...");
	}
}