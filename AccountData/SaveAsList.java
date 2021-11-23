package AccountData;

import java.util.ArrayList;
import java.util.List;

import Account.IAccount;

public class SaveAsList extends DataService{
	
	public List<IAccount> allRegistrants;
	
	public SaveAsList(){
		this.allRegistrants = new ArrayList<IAccount>();
		System.out.println("New IAccount list created\n");
	}

	@Override
	public void addData(IAccount newAccount) {
		System.out.println("Adding IAccount data to list");
		this.allRegistrants.add(newAccount);
	}

	@Override
	public void removeData(IAccount newAccount) {
		System.out.println("Removing IAccount data from list");
		this.allRegistrants.remove(newAccount);
	}
	
	public List <IAccount> getData() {
		System.out.println("Getting IAccount data from list");
		return this.allRegistrants;
	}

}
