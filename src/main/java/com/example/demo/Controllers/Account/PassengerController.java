package com.example.demo.Controllers.Account;

import com.example.demo.Entities.Notification;
import com.example.demo.Entities.Passenger;
import com.example.demo.Services.Account.AccountService;
import com.example.demo.Services.Account.IAccountService;
import com.example.demo.Services.Account.IPassengerService;
import com.example.demo.Services.Account.PassengerService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PassengerController {
    private IPassengerService passengerService;
    private IAccountService accountService;

    public PassengerController() {
    	passengerService = new PassengerService();
    	accountService = new AccountService();
    }
    
    @PostMapping("/register/passenger")
    public boolean add(@RequestBody Passenger newPassenger) {
        return passengerService.add(newPassenger);
    }

    @GetMapping("/passengers")
    public List<Passenger> getAll() {
        return passengerService.getAll();
    }
    
    @GetMapping("/passengers/{username}")
    public Passenger getPassenger(@PathVariable String username) {
        return passengerService.getPassenger(username);
    }
    
    @DeleteMapping("delete/passengers/{username}")
    public boolean delete(@PathVariable String username) {
        return (passengerService.delete(username) && accountService.delete(username));
    }
    
    @GetMapping("/passengers/{username}/notifications")
    public List<Notification> getNotifications(@PathVariable String username) {
        return passengerService.getNotifications(username);
    }

}