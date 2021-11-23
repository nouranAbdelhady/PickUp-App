package Account;

public class Driver extends IAccount{
	
	static int index = 0;
	
	Driver(String username, String password , String email , int mobileNumber){
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.isLoggedIn = false;
		this.isVerified = false;
		this.index++;
	}
	
	Driver(){
		this.index++;
		System.out.println("New driver created with index: " + index);
	}

	@Override
	public void Login(String username, String password) {
		//check against stored if correct
		this.isLoggedIn = true;
		System.out.println("Driver " + username + " successfully logged in");
	}
	
	@Override
	public void Logout() {
		this.isLoggedIn = false;
		System.out.println("Driver " + username + " logged out");
	}
	
	@Override
	public void Register(IAccount toRegister) {
		System.out.println("Driver registration");
	}

}
