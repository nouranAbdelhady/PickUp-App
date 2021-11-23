import java.util.Scanner;

import Account.*;

public class Demo {

	public static void main(String[] args) {
			
		Scanner input = new Scanner(System.in);
		Boolean systemLoop = true;
		IAccount currentUser = null;
		AccountFactory accountFactory = new AccountFactory();
		
		while(systemLoop) {
			System.out.println("1-Passenger");
			System.out.println("2-Driver");
			System.out.println("3-Exit");
			
			int accountChoice = input.nextInt();
			System.out.println();
			
			while (accountChoice>3 || accountChoice<1) {
				System.out.println("Invalid, try again");
				accountChoice = input.nextInt();
			}
			
			if (accountChoice==3) { break; }	//exit app [terminate]
						
			//work on the current user [functions]
			Boolean userChoice = true;
			while(userChoice) {
				System.out.println("1-Register");
				System.out.println("2-Login");
				
				int choice = input.nextInt();
				System.out.println();
				
				switch(choice) {
				  case 1:	//Register
					  System.out.println("Register");
					  //based on the choice, will create User (1-->Passenger / 2-->Driver)
					  currentUser = accountFactory.createAccount(accountChoice);
				      
					  //no break 3ashan ba3d el registration y-login
					  //break;
				  case 2:	//Login
					  System.out.println("Login:");
					  //currentUser = serach for user using username and password
					  //currentUser.Login(null, null);
					  
					  //while loggedIn
					  while(userChoice) {
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
							  System.out.println("Logging out..");
							  //currentUser.Logout();
							  userChoice = false;
							  break;
						  default:
							 System.out.println("Invalid, try again!");
							 continue;
						  }
					  }
				
					  break;
				  default:
					 System.out.println("Invalid, try again!");
					 continue;
				}
			}			
		}
		input.close();
		System.out.println("Exiting app...");
	}

}