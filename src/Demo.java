import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Account.*;
import Admin.AdminManager;

public class Demo {

	public static void main(String[] args) {
			
		Scanner input = new Scanner(System.in);
		Boolean systemLoop = true;
				
		AccountFactory accountFactory = new AccountFactory();
		AccountManager accountManager = new AccountManager();
		
		//////////////	For testing		///////////////////
		IAccount driver1 = new Driver("driver1","password1","driver1@gmail.com",125,123,95);
		IAccount driver2 = new Driver("driver2","password2","driver2@gmail.com",125,456,95);
		IAccount driver3 = new Driver("driver3","password3","driver3@gmail.com",125,789,95);
		
		List<String> favArea1 = new ArrayList<String>(Arrays.asList("Giza","Maadi"));
		List<String> favArea2 = new ArrayList<String>(Arrays.asList("6 October","Giza"));
		List<String> favArea3 = new ArrayList<String>(Arrays.asList("Gize","6 October","Zamalek"));
		
		((Driver) driver1).setFavoriteAreas(favArea1);
		((Driver) driver2).setFavoriteAreas(favArea2);
		((Driver) driver3).setFavoriteAreas(favArea3);		
		
		IAccount passenger1 = new Passenger("passenger1","password1","driver1@gmail.com",123);
		IAccount passenger2 = new Passenger("passenger2","password2","driver2@gmail.com",124);
		IAccount passenger3 = new Passenger("passenger3","password3","driver3@gmail.com",125);
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
					  //accountManager.currentUser = accountFactory.createAccount(accountChoice);
					  //System.out.println();
					  //accountManager.Register(accountManager.currentUser);
					  
					  
					  ///////////// Register all (save to list)  //////////////////////
					  System.out.println();
					  accountManager.Register(driver1);
					  accountManager.Register(driver2);
					  accountManager.Register(driver3);
					  
					  accountManager.Register(passenger1);
					  accountManager.Register(passenger2);
					  accountManager.Register(passenger3);
					  ////////////////////////////////////////////////////
					  
					  
					  //no break 3ashan ba3d el registration y-login
					  //break;
				  case 2:	//Login
					  System.out.println();
					  System.out.println("Login:");
					  input.nextLine();
					  System.out.println("Enter username:");
					  String username = input.nextLine();
					  System.out.println("Enter password:");
					  String password = input.nextLine();
					  
					  if(accountManager.Login(username, password)) {
						  //while loggedIn
						  while(userChoice) {
							  System.out.println();
							  System.out.println("1-Function 1");
							  System.out.println("2-Function 2");
							  System.out.println("3-Logout");
							  System.out.println("4-Go Back");
							  
							  int userFunctionChoice = input.nextInt();
							  System.out.println();
							  
							  switch(userFunctionChoice) {
							  case 1:	//Function 1
								  System.out.println("Function 1 called");
								  break;
							  case 2:	//Function 2
								  System.out.println("Function 2 called");						  
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