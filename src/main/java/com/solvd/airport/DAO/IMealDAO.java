package com.solvd.airport.DAO;

import com.solvd.airport.models.Meal;

public interface IMealDAO extends IDAO<Meal>{
    public void create(Meal m);
    public void update(Meal m);
    public void delete(int id);
}
