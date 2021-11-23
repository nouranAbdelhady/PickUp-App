package Account;

public class AccountFactory {

	//gets details to pass to constructor
	public IAccount createAccount(int accountChoice) {
		if (accountChoice==1) {
			Passenger dummyPassenger =new Passenger();
			return ( dummyPassenger.getDetails() );
		}
		else {
			Driver dummyDriver =new Driver();
			return ( dummyDriver.getDetails() );
		}
	}
}
