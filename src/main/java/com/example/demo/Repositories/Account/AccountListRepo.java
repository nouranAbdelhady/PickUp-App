package com.example.demo.Repositories.Account;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entities.Account.IAccount;

public class AccountListRepo implements AccountRepository{

	 public static List<IAccount> allRegistrants = new ArrayList<IAccount>(); 
	
	@Override
	public boolean removeData(String usernameToRemove) {
		for	(int i=0 ; i <allRegistrants.size() ; i++) {
			if(allRegistrants.get(i).getUsername().compareTo(usernameToRemove) == 0) {
				allRegistrants.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<IAccount> getAll() {
		return AccountListRepo.allRegistrants;
	}

	@Override
	public IAccount get(String username) {
		for	(int i=0 ; i <allRegistrants.size() ; i++) {
			if(allRegistrants.get(i).getUsername().compareTo(username) == 0) {
				return allRegistrants.get(i);
			}
		}
		return null;
	}

	@Override
	public IAccount loginUser(String username, String password) {
		for	(int i=0 ; i <allRegistrants.size() ; i++) {
			if(allRegistrants.get(i).getUsername().compareTo(username) == 0) {
				if(allRegistrants.get(i).getPassword().compareTo(password) == 0) {
					
					//if account is not verified (Driver)
					if(!allRegistrants.get(i).getIsVerified()) {
						return null;
					}
					
					allRegistrants.get(i).setIsLoggedIn(true);
					return allRegistrants.get(i);
				}
			}
		}
		return null;
	}

}
