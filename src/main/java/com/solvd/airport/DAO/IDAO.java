package com.solvd.airport.DAO;

import java.sql.SQLException;

public interface IDAO<T> {
    T getById(int id) throws SQLException;
    void create(T t) throws SQLException;
    void update(T t) throws SQLException;
    void delete(int id) throws SQLException;
}
