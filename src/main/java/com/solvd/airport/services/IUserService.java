package com.solvd.airport.services;

import com.solvd.airport.models.User;

import java.util.List;

public interface IUserService {
    public User getUserByID(int id);
    public void createUser(User u);
    public void updateUser(User u);
    public void deleteUser(int id);
    public List<User> getAllUsers();
}
