package com.solvd.airport.DAO;

import com.solvd.airport.models.Bag;

import java.sql.SQLException;
import java.util.List;

public interface IBagDAO extends IDAO<Bag>{
    public List<Bag> getBagByUser(int userID) throws SQLException;
    public void create(Bag b) throws SQLException;
    public void update(Bag b) throws SQLException;

}
