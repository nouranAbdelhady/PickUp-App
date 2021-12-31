package com.example.demo.Services.Area;

import java.util.List;

import com.example.demo.Entities.*;
import com.example.demo.Entities.Account.Driver;
import com.example.demo.Entities.Account.FavoriteArea;
import com.example.demo.Repositories.Area.FavoriteAreaListRepo;
import com.example.demo.Repositories.Area.FavoriteAreaRepository;

public class AreaService implements IAreaService {
    private FavoriteAreaRepository areaRepo = new FavoriteAreaListRepo();

	@Override
	public boolean add(FavoriteArea newFavoriteArea) {
		return areaRepo.add(newFavoriteArea);
	}

	@Override
	public FavoriteArea get(String name) {
		return areaRepo.get(name);
	}

	@Override
	public List<FavoriteArea> getAll() {
		return areaRepo.getAll();
	}

	@Override
	public boolean update(FavoriteArea toUpdate, Driver newDrver) {
		return areaRepo.update(toUpdate, newDrver);
	}

	@Override
	public List<Driver> getDrivers(String name) {
		
		return areaRepo.getDrivers(name);
	}
}
