package Account;

public abstract class IAccount {
	
	public String type;
	public String username;
	public String password;
	public Boolean isVerified;
	protected String email;
	protected int mobileNumber;
	public Boolean isLoggedIn;
	
	public abstract IAccount getDetails();
}
