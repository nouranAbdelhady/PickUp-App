package com.example.demo.Services.Area;

import java.util.List;

import com.example.demo.Entities.Account.Driver;
import com.example.demo.Entities.Account.FavoriteArea;

public interface IAreaService {
    public boolean add(FavoriteArea newFavoriteArea);
    public FavoriteArea get(String name);
    public List<FavoriteArea> getAll();
    public boolean update(FavoriteArea toUpdate , Driver newDrver);
	public List<Driver> getDrivers(String name);
}
