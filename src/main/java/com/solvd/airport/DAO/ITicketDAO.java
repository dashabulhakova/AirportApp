package com.solvd.airport.DAO;

import com.solvd.airport.models.Ticket;

public interface ITicketDAO extends IDAO<Ticket> {
    public void create(Ticket t);

    public void update(Ticket t);

    public void delete(int id);
}
