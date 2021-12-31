package com.example.demo.Repositories.Area;

import java.util.List;

import com.example.demo.Entities.Driver;
import com.example.demo.Entities.FavoriteArea;

public interface FavoriteAreaRepository {

	boolean add(FavoriteArea favoriteArea);
	FavoriteArea get(String name);
    List<FavoriteArea> getAll();
    boolean delete(String name);
	boolean update(FavoriteArea targetedArea, Driver newSub);
	List<Driver> getDrivers(String name);
  	
}
