package com.solvd.airport.DAO;

import com.solvd.airport.models.Meal;
import com.solvd.airport.models.Ticket;
import com.solvd.airport.utils.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TicketDAOImpl implements ITicketDAO {
    private static final Logger LOGGER = Logger.getLogger(MealDAOImpl.class.getName());
    private static final String INSERT = "INSERT INTO tickets (id, price, seat, flight_date) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE tickets SET  price = ?, seat = ?, flight_date = ? WHERE id = ?;";
    private static final String DELETE = "DElETE FROM tickets WHERE id = ?";

    @Override
    public Ticket getById(int id) throws SQLException {
        return null;
    }

    @Override
    public void create(Ticket t) {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(INSERT);
            ps.setInt(1, t.getId());
            ps.setInt(2, t.getPrice());
            ps.setInt(3, t.getSeat());
            ps.setDate(4, (Date) t.getFlightDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + "Ticket was not created");
        } finally {
            ConnectionPool.getInstance().returnConnection(c);
            assert ps != null;
        }
    }

    @Override
    public void update(Ticket t) {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(UPDATE);
            ps.setInt(1, t.getId());
            ps.setInt(2, t.getPrice());
            ps.setInt(3, t.getSeat());
            ps.setDate(4, (Date) t.getFlightDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + "Cannot update bags");
        } finally {
            assert ps != null;
            ConnectionPool.getInstance().returnConnection(c);
        }
    }

    @Override
    public void delete(int id) {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(DELETE);
            ps.setInt(1,id);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + "Could not delete");
        } finally {
            ConnectionPool.getInstance().returnConnection(c);
        }
    }
}
