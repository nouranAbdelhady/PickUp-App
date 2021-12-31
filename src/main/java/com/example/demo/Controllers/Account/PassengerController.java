package com.example.demo.Controllers.Account;

import com.example.demo.Entities.Account.Notification;
import com.example.demo.Entities.Account.Passenger;
import com.example.demo.Entities.Ride.Ride;
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
    public String add(@RequestBody Passenger newPassenger) {
    	if( passengerService.add(newPassenger) ) {
        	return "New passenger successfully registered";
        }
        else {
        	return "Error: registration not successful";
        }
    }

    @GetMapping("/passengers")
    public List<Passenger> getAll() {
        return passengerService.getAll();
    }
    
    @GetMapping("/passengers/{username}")
    public Passenger getPassenger(@PathVariable String username) {
        return passengerService.getPassenger(username);
    }
    
    @GetMapping("/passengers/{username}/requestedRide")
    public Ride getRequestedRide(@PathVariable String username) {
    	return passengerService.getRequestedRide(username);
    }
    
    @DeleteMapping("delete/passengers/{username}")
    public String delete(@PathVariable String username) {
        if( passengerService.delete(username) && accountService.delete(username) ) {
        	return "Passenger with username:"+username+" successfully deleted.";
        }
        else {
        	return "Error: deletion not successful";
        }   
    }
    
    @GetMapping("/passengers/{username}/notifications")
    public List<Notification> getNotifications(@PathVariable String username) {
        return passengerService.getNotifications(username);
    }
    
    @GetMapping("/passengers/{username}/currentRide")
    public Ride getCurrentRide(@PathVariable String username) {
    	Passenger targetedPassenger = passengerService.getPassenger(username);
    	if(targetedPassenger!=null && targetedPassenger.getIsLoggedIn()) {
    		return passengerService.getCurrentRide(targetedPassenger);
    	}
    	else {
    		return null;		//passenger not logged in
    	}
    }
    
    @GetMapping("/passengers/{username}/previousRides")
    public List<Ride> getPreviousRides(@PathVariable String username) {
    	Passenger targetedPassenger = passengerService.getPassenger(username);
    	if(targetedPassenger!=null && targetedPassenger.getIsLoggedIn()) {
    		return passengerService.getPreviousRides(targetedPassenger);
    	}
    	else {
    		return null;		
    	}
    }

}