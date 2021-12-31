package com.example.demo.Controllers.Ride;

import java.util.List;

import com.example.demo.Entities.*;
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
    private IRidesService service = new RidesService();

    @PostMapping("add/ride")
    public Boolean add(@RequestBody Ride ride) {
        return service.add(ride);
    }

    @GetMapping("/rides")
    public List<Ride> getAll() {
        return service.getAll();
    }

    @GetMapping("/rides/{id}")
    public Ride get(@PathVariable int id) {
        return service.get(id);
    }
    
    @GetMapping("/rides/{rideId}/offer/{offerId}")
    public Offer getOffer(@PathVariable int rideId , @PathVariable int offerId) {
        return service.getOffer(rideId,offerId);
    }

    @DeleteMapping("/rides/{id}/delete")
    public boolean delete(@PathVariable int id) {
        return service.delete(id);
    }
    
    @PostMapping("/rides/{id}/update")
    public boolean update(@PathVariable int id, @RequestBody Offer newOffer) {
    	Ride toUpdate =  service.get(id);
        return service.update(toUpdate,newOffer);
    }
}