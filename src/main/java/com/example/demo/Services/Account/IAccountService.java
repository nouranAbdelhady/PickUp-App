package com.example.demo.Services.Account;

import java.util.List;

import com.example.demo.Entities.Account.IAccount;

public interface IAccountService {
	
    public IAccount get(String username);
    public List<IAccount> getAll();
    public boolean delete(String username);
	public IAccount login(String username, String password);
	
}
