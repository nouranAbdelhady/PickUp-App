package Account;

import java.util.Scanner;

public class Driver extends IAccount{
		
	public int license;
	public int nationalId;
	
	Driver(String username, String password , String email , int mobileNumber , int license , int nationalId){
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.isLoggedIn = false;
		this.isVerified = false;
		this.license = license;
		this.nationalId = nationalId;
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
		
		IAccount newAcc = new Driver(username,password,email,mobileNu,license,nationalid);
		
		input.nextLine();
		//input.close();
		return newAcc;
	}

}
