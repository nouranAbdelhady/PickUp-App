package AccountData;

import java.util.List;
import Account.IAccount;

public abstract class DataService {	
	
	public abstract void addData(IAccount newAccount);
	public abstract void removeData(IAccount newAccount);
	
	//general?
	public abstract List<IAccount> getData();
	
}