package com.example.demo.Controllers.Area;

import java.util.List;

import com.example.demo.Entities.*;
import com.example.demo.Entities.Account.Driver;
import com.example.demo.Entities.Account.FavoriteArea;
import com.example.demo.Services.Account.DriverService;
import com.example.demo.Services.Account.IDriverService;
import com.example.demo.Services.Area.AreaService;
import com.example.demo.Services.Area.IAreaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AreaController {
    private IAreaService areaService;
    private IDriverService driverService; 
    
    public AreaController() {
    	areaService = new AreaService();
    	driverService = new DriverService();
    }

    @GetMapping("/areas")
    public List<FavoriteArea> getAll() {
        return areaService.getAll();
    }
    
    @GetMapping("/areas/{name}/drivers")
    public List<Driver> getDrivers(@PathVariable String name) {
        return areaService.getDrivers(name);
    }

    @GetMapping("/areas/{name}")
    public FavoriteArea get(@PathVariable String name) {
        return areaService.get(name);
    }
    
    @PostMapping("/drivers/{username}/new/favoriteArea")
    public String add(@PathVariable String username, @RequestBody FavoriteArea newArea) {
        Driver targetedDriver = driverService.getDriver(username);
        
        if( targetedDriver!=null && targetedDriver.getIsLoggedIn() ) {
        	targetedDriver.addFavoriteAreas(newArea);
        	areaService.update(newArea, targetedDriver);
        	return "New favorite area successfully added";
        }
        else {
        	return "Error: Invalid username provided OR driver is not verified/logged in yet";
        }
       
    }
}