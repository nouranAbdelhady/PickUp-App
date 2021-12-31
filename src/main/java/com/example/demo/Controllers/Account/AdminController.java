package com.example.demo.Controllers.Account;

import com.example.demo.Entities.Driver;
import com.example.demo.Services.Account.DriverService;
import com.example.demo.Services.Account.IDriverService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    private IDriverService driverService;

    public AdminController() {
        driverService = new DriverService();
    }
    
    @GetMapping("/admin/pendingDrivers")
    public List<Driver> getAllPending() {
        return driverService.getPendingDrivers();
    }
    
    @GetMapping("/admin/pendingDrivers/{username}")
    public Driver getSinglePending(@PathVariable String username) {
        return driverService.getSinglePending(username);
    }
    
    @PutMapping("/admin/pendingDrivers/{username}/verify")
    public boolean verify(@PathVariable String username) {
        Driver targetedDriver = getSinglePending(username);
        return driverService.updateVerify(targetedDriver);
    }
        
}