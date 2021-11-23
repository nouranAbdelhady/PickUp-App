import java.util.Scanner;

import Account.*;
import Admin.AdminManager;

public class Demo {

	public static void main(String[] args) {
			
		Scanner input = new Scanner(System.in);
		Boolean systemLoop = true;
				
		AccountFactory accountFactory = new AccountFactory();
		AccountManager accountManager = new AccountManager();
		
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
				System.out.println("1-Get ALL registrants");
				System.out.println("2-Get pending drivers");
				System.out.println("4-Get ALL currently logged in");
				System.out.println("3-Go Back");
				
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
						}
					}
				}
				//else --> go back (4)
				continue;
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