package com.example.demo.Repositories.Account;

import java.util.List;

import com.example.demo.Entities.Account.IAccount;

public interface AccountRepository {
	
	public boolean removeData(String usernameToRemove);
	public List<IAccount> getAll();
	public IAccount get(String username);
	public IAccount loginUser(String username, String password);

}
