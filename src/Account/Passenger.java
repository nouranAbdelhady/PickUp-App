package Account;

public class Passenger extends IAccount{
	
	static int index = 0;
	
	Passenger(String username, String password , String email , int mobileNumber){
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.isLoggedIn = false;
		this.isVerified = true;
		this.index++;
	}
	
	Passenger(){
		this.index++;
		System.out.println("New passenger created with index: " + index);
	}

	@Override
	public void Login(String username, String password) {
		//check against stored if correct
		this.isLoggedIn = true;
		System.out.println("Passenger " + username + " successfully logged in");
	}
	
	@Override
	public void Logout() {
		this.isLoggedIn = false;
		System.out.println("Passenger " + username + " logged out");
	}

	@Override
	public void Register(IAccount toRegister) {
		// TODO Auto-generated method stub
		System.out.println("Passenger registration");
	}

}
