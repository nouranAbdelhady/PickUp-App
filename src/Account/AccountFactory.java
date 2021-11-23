package Account;

public class AccountFactory {

	public IAccount createAccount(int accountChoice) {
		if (accountChoice==1) {
			return ( new Passenger() );
		}
		else {
			return ( new Driver() );
		}
	}
}
