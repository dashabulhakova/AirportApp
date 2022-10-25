package com.solvd.airport.DAO;

import com.solvd.airport.models.User;

import java.sql.SQLException;

public interface IUserDAO extends IDAO<User> {
    public User getById(int id) throws SQLException;
    public void create (User u) throws SQLException;
    public void update (User u) throws SQLException;
    public void delete (int id) throws SQLException;
}
