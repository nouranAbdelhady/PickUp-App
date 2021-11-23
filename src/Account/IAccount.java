package Account;

public abstract class IAccount {
	
	protected String username;
	protected String password;
	protected Boolean isVerified;
	protected String email;
	protected int mobileNumber;
	protected Boolean isLoggedIn;
	
	public abstract void Register(IAccount toRegister);
	
	//should return Boolean
	public abstract void Login(String username , String password);
	
	public abstract void Logout();
	
}
