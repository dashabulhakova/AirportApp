package com.solvd.airport.DAO;

import com.solvd.airport.models.Meal;
import com.solvd.airport.utils.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MealDAOImpl implements IMealDAO{
    private static final Logger LOGGER = Logger.getLogger(MealDAOImpl.class.getName());
    private static final String INSERT = "INSERT INTO meals (id, meal_type, price) VALUES (?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE meals SET  meal_type = ?, price = ? WHERE id = ?;";
    private static final String DELETE = "DElETE FROM meals WHERE id = ?";

    @Override
    public Meal getById(int id) throws SQLException {
        return null;
    }

    @Override
    public void create(Meal m) {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(INSERT);
            ps.setInt(1, m.getId());
            ps.setString(2, m.getMealType());
            ps.setInt(3, m.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + "bag was not created");
        } finally {
            ConnectionPool.getInstance().returnConnection(c);
            assert ps != null;
        }
    }

    @Override
    public void update(Meal m) {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(UPDATE);
            ps.setInt(1, m.getId());
            ps.setString(2, m.getMealType());
            ps.setInt(3, m.getPrice());
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
