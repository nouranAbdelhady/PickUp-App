package com.example.demo.Controllers.Ride;

import com.example.demo.Entities.Account.Passenger;
import com.example.demo.Entities.Ride.Rate;
import com.example.demo.Entities.Ride.Ride;
import com.example.demo.Services.Account.IPassengerService;
import com.example.demo.Services.Account.PassengerService;
import com.example.demo.Services.Ride.IRidesService;
import com.example.demo.Services.Ride.RidesService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateController {
    private IRidesService rideService;
    private IPassengerService passengerService;
    
    public RateController() {
    	rideService = new RidesService();
    	passengerService = new PassengerService();
    }
    
    @PostMapping("/passengers/{username}/previousRides/{rideId}/add/rate")
    public String addRate(@PathVariable String username , @PathVariable int rideId , @RequestBody Rate newRate) {
    	Passenger targetedPassenger = passengerService.getPassenger(username);
    	Ride targetedRide = rideService.get(rideId);
    	if(targetedPassenger!=null && targetedPassenger.getIsLoggedIn()) {
    		if(rideService.addRate(targetedRide,newRate)) {
	    		return "New rating added to ride:"+rideId;
	    	}
    		else {
    			return "Error: ride already rated";
    		}
    	}
    	    	
    	return "Error: Passenger not logged in";
    }
    
    @GetMapping("/passengers/{username}/previousRides/{rideId}/rating")
    public Rate getRate(@PathVariable String username , @PathVariable int rideId) {
    	Passenger targetedPassenger = passengerService.getPassenger(username);
    	
    	if(targetedPassenger!=null && targetedPassenger.getIsLoggedIn()) {
    		Ride targetedRide = rideService.get(rideId);
        	return rideService.getRate(targetedRide);
    	}
    	    	
    	return null;	//passenger not logged in
    }
    
    @GetMapping("/rides/{id}/rating")
    public Rate get(@PathVariable int id) {
        return rideService.getRate(rideService.get(id));
    }
}