package com.example.demo.Controllers.Ride;

import com.example.demo.Entities.*;
import com.example.demo.Services.Account.DriverService;
import com.example.demo.Services.Account.IDriverService;
import com.example.demo.Services.Account.IPassengerService;
import com.example.demo.Services.Account.PassengerService;
import com.example.demo.Services.Ride.IRidesService;
import com.example.demo.Services.Ride.RidesService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController {
    private IRidesService rideService;
    private IDriverService driverService;
    private IPassengerService passengerService;
    
    public OfferController() {
    	rideService = new RidesService();
    	driverService = new DriverService();
    	passengerService = new PassengerService();
    }
    
    @PostMapping("/drivers/{username}/avaliableRides/{rideId}/add/offer")
    public boolean updateRide(@PathVariable int rideId,@PathVariable String username, @RequestBody Offer newOffer) {
    	Ride toUpdate =  rideService.get(rideId);
    	Driver suggestedBy = driverService.getDriver(username);
    	newOffer.setSuggestedBy(suggestedBy);
        return rideService.update(toUpdate,newOffer);
    }
    
    @GetMapping("/rides/{rideId}/offers")
    public List<Offer> getOffers(@PathVariable int rideId) {
        return rideService.getOffers(rideId);
    }
    
    @GetMapping("/rides/{rideId}/offers/{offerId}")
    public Offer getOffer(@PathVariable int rideId , @PathVariable int offerId) {
        return rideService.getOffer(rideId,offerId);
    }
    
    @GetMapping("/passengers/{username}/requestedRide/offers")
    public List<Offer> getOffersForRide(@PathVariable String username) {
    	Ride targetedRide = passengerService.getRequestedRide(username);
    	System.out.println("Ride ID:"+targetedRide.getRideId());
    	return rideService.getOffers(targetedRide.getRideId());
    }
    
    @GetMapping("/passengers/{username}/requestedRide/offers/{offerId}")
    public Offer getSingleOfferForRide(@PathVariable String username , @PathVariable int offerId) {
    	Ride targetedRide = passengerService.getRequestedRide(username);
    	return rideService.getOffer(targetedRide.getRideId(),offerId);
    }
}