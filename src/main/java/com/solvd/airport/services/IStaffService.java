package com.solvd.airport.services;

import com.solvd.airport.models.Staff;

import java.util.List;

public interface IStaffService {
    public Staff getStaffByID(int id);
    public void createStaff(Staff s);
    public void updateStaff(Staff s);
    public void deleteStaff(int id);
    public List<Staff> getAllStaff();
}
