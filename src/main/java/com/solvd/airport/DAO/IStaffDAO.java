package com.solvd.airport.DAO;

import com.solvd.airport.models.Staff;

import java.sql.SQLException;
import java.util.List;

public interface IStaffDAO extends IDAO<Staff> {
    Staff getById(int id) throws SQLException;
    void create (Staff s) throws SQLException;
    void update (Staff s) throws SQLException;
    void delete (int id) throws SQLException;
    List<Staff> getAllStaff();
}
