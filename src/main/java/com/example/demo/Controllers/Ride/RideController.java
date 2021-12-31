package com.example.demo.Controllers.Ride;

import java.util.List;

import com.example.demo.Entities.*;
import com.example.demo.Services.Account.IPassengerService;
import com.example.demo.Services.Account.PassengerService;
import com.example.demo.Services.Area.AreaService;
import com.example.demo.Services.Area.IAreaService;
import com.example.demo.Services.Ride.IRidesService;
import com.example.demo.Services.Ride.RidesService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RideController {
    private IRidesService rideService;
    private IPassengerService passengerService;
    public IAreaService areaService;
    
    public RideController() {
    	rideService = new RidesService();
    	areaService = new AreaService();
    	passengerService = new PassengerService();
    }

    //request a new ride
    @PostMapping("/passengers/{username}/add/ride")
    public Boolean add(@PathVariable String username,@RequestBody Ride ride) {
    	Passenger requestedBy = passengerService.getPassenger(username);
    	ride.setRequestedBy(requestedBy);
        return rideService.add(ride);
    }

    @GetMapping("/rides")
    public List<Ride> getAll() {
        return rideService.getAll();
    }

    @GetMapping("/rides/{id}")
    public Ride get(@PathVariable int id) {
        return rideService.get(id);
    }
    
    @GetMapping("/rides/{rideId}/offer/{offerId}")
    public Offer getOffer(@PathVariable int rideId , @PathVariable int offerId) {
        return rideService.getOffer(rideId,offerId);
    }

    @DeleteMapping("/rides/{id}/delete")
    public boolean delete(@PathVariable int id) {
        return rideService.delete(id);
    }
    
    @PostMapping("/rides/{id}/update")
    public boolean update(@PathVariable int id, @RequestBody Offer newOffer) {
    	Ride toUpdate =  rideService.get(id);
        return rideService.update(toUpdate,newOffer);
    }
}