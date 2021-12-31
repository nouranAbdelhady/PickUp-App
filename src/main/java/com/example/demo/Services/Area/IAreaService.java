package com.example.demo.Services.Area;

import java.util.List;

import com.example.demo.Entities.Driver;
import com.example.demo.Entities.FavoriteArea;

public interface IAreaService {
    public boolean add(FavoriteArea newFavoriteArea);
    public FavoriteArea get(String name);
    public List<FavoriteArea> getAll();
    public boolean update(FavoriteArea toUpdate , Driver newDrver);
}
