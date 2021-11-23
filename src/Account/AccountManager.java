package Account;

import java.util.ArrayList;
import java.util.List;

import AccountData.Registrations;

public class AccountManager {
	Registrations registrations;
	
	public IAccount currentUser = null;
	
	public AccountManager() {
		registrations = new Registrations();
	}
	
	public void Register(IAccount toRegister) {
		registrations.savedData.addData(toRegister);
		System.out.println(toRegister.type + " : " + toRegister.username +" registered");
	}
	
	public Boolean Login(String username , String password) {
		Boolean returnValue = false;
		List<IAccount> allRegistrants = registrations.savedData.getData();
		for (IAccount singleRegistration : allRegistrants) {
            if(singleRegistration.username.compareTo(username)==0) {	//correct username
            	if(singleRegistration.password.compareTo(password)==0)	//correct password
            	{
            		if(singleRegistration.isVerified) {	//check if verified before logging in
            			returnValue=true;
            			System.out.println(username + " logged in successfully");
            			singleRegistration.isLoggedIn = true;
            			currentUser = singleRegistration;
            			return true;
            		}
            		else {
            			System.out.println("Can't login, not verified yet");
            			return false;
            		}
            	}
            	else {
            		System.out.println("Incorrect password entered");
            		return false;
            	}
            }
        }
		
		if(!returnValue) {
			System.out.println("Invalid username entered");
		}
		
		return returnValue;
	}
	
	public void Logout() {
		currentUser.isLoggedIn = false;
		System.out.println(currentUser.username + " logged out");
		currentUser = null;
	}
	
	public List<IAccount> getAllRegistrants() {
		List<IAccount> allRegistrants = registrations.savedData.getData();
		
		for (IAccount singleRegistration : allRegistrants) {
            System.out.print(singleRegistration.type + " : " + singleRegistration.username);
            if(singleRegistration.type.compareTo("Driver")==0) {
            	System.out.print(" , Favorite Areas : " + ((Driver) singleRegistration).getFavoriteAreas());
            }
            System.out.println();
        }
		return allRegistrants;
	}
	
	public List<IAccount> getAllPassengers() {
		List<IAccount> allRegistrants = registrations.savedData.getData();
		
		List<IAccount> allPassengers = new ArrayList<IAccount>();
		for (IAccount singleRegistration : allRegistrants) {
			if (singleRegistration.type.compareTo("Passenger")==0)
			{
				allPassengers.add(singleRegistration);
				System.out.println("Username: " + singleRegistration.username);
			}		
        }
		
		return allPassengers;
	}
	
	public List<Driver> getAllDrivers() {
		List<IAccount> allRegistrants = registrations.savedData.getData();
		
		List<Driver> allDrivers = new ArrayList<Driver>();
		for (IAccount singleRegistration : allRegistrants) {
			if (singleRegistration.type.compareTo("Driver")==0)
			{
				allDrivers.add((Driver) singleRegistration);
				//System.out.println("Username: " + singleRegistration.username);
				//System.out.println("License: " + ((Driver) singleRegistration).license);
				//System.out.println("National ID: " + ((Driver) singleRegistration).nationalId);
				
				//System.out.println();
				
			}		
        }
		
		return allDrivers;
	}
	
	public List<Driver> getPendingDrivers() {
		List<Driver> allDrivers = this.getAllDrivers();
		
		List<Driver> pendingDrivers = new ArrayList<Driver>();
		for (Driver singleDriver : allDrivers) {
			if (!singleDriver.isVerified)
			{
				pendingDrivers.add(singleDriver);
				System.out.println(singleDriver);
			}
        }
		
		return pendingDrivers;
	}
	
}
