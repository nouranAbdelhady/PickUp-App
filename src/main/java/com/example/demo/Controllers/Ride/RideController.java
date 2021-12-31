package com.example.demo.Controllers.Ride;

import java.util.List;

import com.example.demo.Entities.Account.Passenger;
import com.example.demo.Entities.Distance.GoogleMapsCalculator;
import com.example.demo.Entities.Distance.HarvesineCalculator;
import com.example.demo.Entities.Distance.IDistanceCalculator;
import com.example.demo.Entities.Ride.Ride;
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
    
    public static int APICount =0;
    IDistanceCalculator distanceCalculator;
    
    public RideController() {
    	rideService = new RidesService();
    	areaService = new AreaService();
    	passengerService = new PassengerService();
    }
    
    private IDistanceCalculator getDistanceCalculationStrategy() {
    	//exceeded specific number of calls (assume it is 2)
		if(APICount>2) {
			return (new HarvesineCalculator());			
		}
		else {
			return (new GoogleMapsCalculator());
		}
	}

    //request a new ride
    @PostMapping("/passengers/{username}/add/ride")
    public String add(@PathVariable String username,@RequestBody Ride ride) {
    	
    	Passenger requestedBy = passengerService.getPassenger(username);
    	
    	if( requestedBy!=null && requestedBy.getIsLoggedIn() ) {
    		APICount++;
    		ride.setRequestedBy(requestedBy);
        	
        	//calculate distance
        	distanceCalculator = getDistanceCalculationStrategy();
        	//Google --> 10 / Harvesine --> 20
        	ride.setDistance(distanceCalculator.calculateDistance());
        	ride.setETA(distanceCalculator.calculateETA());   	
        	
        	//save data to repo
        	//ride.sub(requestedBy);
            rideService.add(ride);
            return "New ride with id: "+ride.getRideId()+" requested";
        }
        else {
        	return "Error: Passenger is not logged in";
        } 	
    }    

	@GetMapping("/rides")
    public List<Ride> getAll() {
        return rideService.getAll();
    }

    @GetMapping("/rides/{id}")
    public Ride get(@PathVariable int id) {
        return rideService.get(id);
    }

    @DeleteMapping("/rides/{id}/delete")
    public String delete(@PathVariable int id) {
    	if( rideService.delete(id) ) {
        	return "Ride with id:"+id+" successfully deleted.";
        }
        else {
        	return "Error: deletion not successful";
        }        	
    }
   
}