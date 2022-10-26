package com.solvd.airport.DAO;

import com.solvd.airport.models.Airline;

public interface IAirlineDAO {
    public Airline getAirlineByID(int id);

    public void createAirline(Airline a);

    public void updateAirline(Airline a);

    public void deleteAirline(Airline a);
}
