package com.example.demo.Services.Account;

import java.util.List;

import com.example.demo.Entities.*;
import com.example.demo.Entities.Account.IAccount;
import com.example.demo.Repositories.Account.*;

public class AccountService implements IAccountService {
    
	private static AccountRepository repository;
    public static IAccount currentlyLoggedIn;
    
    public AccountService(){
    	repository = new AccountListRepo();
    	currentlyLoggedIn = null;
    }

    @Override
    public IAccount get(String username) {
    	return repository.get(username);
    }

    @Override
    public List<IAccount> getAll() {
        return repository.getAll();
    }

    @Override
    public boolean delete(String username) {
        return repository.removeData(username);
    }

	@Override
	public IAccount login(String username, String password) {
		return repository.loginUser(username,password);
	}

}
