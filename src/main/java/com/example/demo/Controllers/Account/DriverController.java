package com.example.demo.Controllers.Account;

import com.example.demo.Entities.Driver;
import com.example.demo.Entities.FavoriteArea;
import com.example.demo.Entities.Notification;
import com.example.demo.Entities.Ride;
import com.example.demo.Services.Account.AccountService;
import com.example.demo.Services.Account.DriverService;
import com.example.demo.Services.Account.IAccountService;
import com.example.demo.Services.Account.IDriverService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverController {
    private IDriverService driverService;
    private IAccountService accountService;

    public DriverController() {
        driverService = new DriverService();
        accountService = new AccountService();
    }
    
    @PostMapping("/register/driver")
    public String add(@RequestBody Driver newDriver) {
        if( driverService.add(newDriver) ) {
        	return "New driver successfully registered";
        }
        else {
        	return "Error: registration not successful";
        }
    }

    @GetMapping("/drivers")
    public List<Driver> getAll() {
        return driverService.getAll();
    }
    
    @GetMapping("/drivers/{username}")
    public Driver getDriver(@PathVariable String username) {
        return driverService.getDriver(username);
    }
    
    @GetMapping("/drivers/{username}/favoriteAreas")
    public List<FavoriteArea> getFavoriteAreas(@PathVariable String username) {
    	Driver targetedDriver = driverService.getDriver(username);
    	if(targetedDriver!=null && targetedDriver.getIsLoggedIn()) {
    		return driverService.getFavoriteAreas(targetedDriver);
    	}
    	else {
    		return null;		//driver not logged in
    	}
    }
    
    @GetMapping("/drivers/{username}/avaliableRides")
    public List<Ride> getavaliableRides(@PathVariable String username) {
    	Driver targetedDriver = driverService.getDriver(username);
    	if(targetedDriver!=null && targetedDriver.getIsLoggedIn()) {
    		return driverService.getavaliableRides(targetedDriver);
    	}
    	else {
    		return null;		//driver not logged in
    	}
        
    }
    
    @DeleteMapping("delete/driver/{username}")
    public String delete(@PathVariable String username) {
    	if( driverService.delete(username) && accountService.delete(username) ) {
        	return "Driver with username:"+username+" successfully deleted.";
        }
        else {
        	return "Error: deletion not successful";
        }    	
    }
    
    @GetMapping("/drivers/{username}/notifications")
    public List<Notification> getNotifications(@PathVariable String username) {
    	Driver targetedDriver = driverService.getDriver(username);
    	if(targetedDriver!=null && targetedDriver.getIsLoggedIn()) {
    		return driverService.getNotifications(targetedDriver);
    	}
    	else {
    		return null;		//driver not logged in
    	}
    }
        
}