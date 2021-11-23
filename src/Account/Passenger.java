package Account;

import java.util.Scanner;

public class Passenger extends IAccount{
	
	
	Passenger(String username, String password , String email , int mobileNumber){
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
}
