package Admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Account.AccountManager;
import Account.Driver;
import Account.IAccount;

public class AdminManager {
	
	AccountManager accountManager;
	
	public AdminManager(AccountManager accountManager)
	{
		this.accountManager = accountManager;
	}
	
	public void Verify(IAccount singleDriver) {
		singleDriver.isVerified = true;
		System.out.println("Driver: " + singleDriver.username + " successfully verified");
		System.out.println();
	}
	
	public void getPendingDrivers() {
		Scanner input = new Scanner(System.in);
		List<Driver> allDrivers = accountManager.getAllDrivers();
		
		List<Driver> pendingDrivers = new ArrayList<Driver>();
		for (Driver singleDriver : allDrivers) {
			if (!singleDriver.isVerified)
			{	
				System.out.println("Username: " + singleDriver.username);
				System.out.println("License: " + ((Driver) singleDriver).license);
				System.out.println("National ID: " + ((Driver) singleDriver).nationalId);
				System.out.println();
				
				System.out.println("Do you want to verify? [Y/N]");
				String option = input.nextLine();
				if(option.compareTo("Y")==0) {	//anything else --> no
					this.Verify(singleDriver);
					continue;
				}
				pendingDrivers.add(singleDriver);
			}
        }
		
		//return pendingDrivers;
	}
	
	public void getAllLoggedIn() {
		List<IAccount> allRegistrants = accountManager.getAllRegistrants();	//outputs all
		
		
		System.out.println();
		System.out.println("Logged in :");
		for (IAccount singleRegistration : allRegistrants) {
			if (singleRegistration.isLoggedIn)
			{
				System.out.println(singleRegistration.type + " : " + singleRegistration.username);
			}
        }
		
	}

}
