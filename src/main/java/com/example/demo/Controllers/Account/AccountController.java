package com.example.demo.Controllers.Account;


import com.example.demo.Entities.*;
import com.example.demo.Entities.Account.IAccount;
import com.example.demo.Services.Account.AccountService;
import com.example.demo.Services.Account.IAccountService;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private IAccountService accountService;

    public AccountController() {
        accountService = new AccountService();
    }

    @GetMapping("/accounts")
    public List<IAccount> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/accounts/{username}")
    public IAccount get(@PathVariable String username) {
        return accountService.get(username);
    }
    
    @RequestMapping("/login")
    //param section in postman
    public String login(@RequestParam String username, @RequestParam String password) {
        IAccount loggedInAccount = accountService.login(username,password);
        
    	//System.out.println("Username: "+username);
    	//System.out.println("Password: "+password);
        
        if( loggedInAccount!=null ) {
        	AccountService.currentlyLoggedIn = loggedInAccount;
        	return "Login successful";
        }
        else {
        	return "Error: Invalid account details entered";
        }   
    }
    
}