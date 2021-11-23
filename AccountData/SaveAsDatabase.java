package AccountData;

import java.util.List;

import Account.IAccount;

public class SaveAsDatabase extends DataService{
	
	//databaseObject
	//will assume that the type is String for now, later will change to database
	
	SaveAsDatabase(){
		System.out.println("New IAccount database created");
	}

	@Override
	public void addData(IAccount newAccount) {
		System.out.println("Adding IAccount data to database");
		//databaseObject.save()
	}

	@Override
	public void removeData(IAccount newAccount) {
		System.out.println("Removing IAccount data from database");
	}

	//should return database?
	@Override
	public List<IAccount> getData() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
