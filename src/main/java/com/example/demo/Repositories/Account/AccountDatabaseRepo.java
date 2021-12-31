package com.example.demo.Repositories.Account;

import java.util.List;

import com.example.demo.Entities.IAccount;

public class AccountDatabaseRepo implements AccountRepository{

	//database obj
	
	@Override
	public boolean removeData(String usernameToRemove) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<IAccount> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IAccount get(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public IAccount loginUser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}	

}
