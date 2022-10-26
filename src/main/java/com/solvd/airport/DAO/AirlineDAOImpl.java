package com.solvd.airport.DAO;

import com.solvd.airport.models.Airline;
import com.solvd.airport.utils.ConnectionPool;

import java.sql.Connection;

public class AirlineDAOImpl implements IAirlineDAO {
    @Override
    public Airline getAirlineByID(int id) {
        Connection c = ConnectionPool.getInstance().getConnection();
        ConnectionPool.getInstance().returnConnection(c);
        return null;
    }

    @Override
    public void createAirline(Airline a) {
        Connection c = ConnectionPool.getInstance().getConnection();
        ConnectionPool.getInstance().returnConnection(c);
    }

    @Override
    public void updateAirline(Airline a) {
        Connection c = ConnectionPool.getInstance().getConnection();
        ConnectionPool.getInstance().returnConnection(c);
    }

    @Override
    public void deleteAirline(Airline a) {
        Connection c = ConnectionPool.getInstance().getConnection();
        ConnectionPool.getInstance().returnConnection(c);
    }
}
