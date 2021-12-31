package com.example.demo.Repositories.Area;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entities.*;

public class FavoriteAreaListRepo implements FavoriteAreaRepository {

    private static List<FavoriteArea> allAreas = new ArrayList<FavoriteArea>();

    @Override
    public boolean add(FavoriteArea newArea) {
    	//already checked if it exists or not in update
        return allAreas.add(newArea);
    }

    @Override
    public FavoriteArea get(String name) {
        for (FavoriteArea singleArea : allAreas) {
            if (singleArea.getAreaName().compareTo(name)==0) {
                return singleArea;
            }
        }
        return null;
    }
    
  
    @Override
    public List<FavoriteArea> getAll() {
        return allAreas;
    }

    @Override
    public boolean delete(String name) {
        for (FavoriteArea singleArea : allAreas) {
            if (singleArea.getAreaName() == name) {
                return allAreas.remove(singleArea);
            }
        }
        return false;
    }
    
    //subscribe driver
    @Override
    public boolean update(FavoriteArea targetedArea , Driver newSub) {    
    	for (FavoriteArea singleArea : allAreas) {
    		//area already exists
            if (singleArea.getAreaName() == targetedArea.getAreaName()) {	
                return singleArea.subscribeDriver(newSub);
            }
        }
    	//area doesn't exist
    	{
    		//new subscriber
    		targetedArea.subscribeDriver(newSub);
    	}
        return this.add(targetedArea);
    }

	@Override
	public List<Driver> getDrivers(String name) {
		FavoriteArea targetedArea = this.get(name);
		return targetedArea.getDriversWithFavoriteArea();
	}
  
}