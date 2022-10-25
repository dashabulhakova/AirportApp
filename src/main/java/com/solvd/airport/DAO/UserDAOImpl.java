package com.solvd.airport.DAO;

import com.solvd.airport.models.User;
import com.solvd.airport.utils.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
    private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class.getName());
    private static final String READ = "SELECT * FROM Users where id = ?";
    private static final String READALL = "SELECT * FROM Users";
    private static final String INSERT = "INSERT INTO Users (id, first_name, last_name, email) VALUES (?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE Users SET first_name = ? WHERE id = ?;";
    private static final String DELETE = "DElETE FROM Users WHERE id = ?";

    @Override
    public User getById(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(READ);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                User user = new User(id, firstName, lastName, email);
                return user;
            }
        } catch (SQLException e) {
            String message = String.format("Getting user with ID:%d wasn't successful", id);
            LOGGER.error(message, e);
        } finally {
            assert rs != null;
            rs.close();
            ps.close();
            ConnectionPool.getInstance().returnConnection(c);
        }
        return null;
    }

    @Override
    public void create(User u) {
        Connection con = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(INSERT);
            ps.setInt(1, u.getId());
            ps.setString(2, u.getFirstName());
            ps.setString(3, u.getLastName());
            ps.setString(4, u.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Can't create a user", e);
        } finally {
            ConnectionPool.getInstance().returnConnection(con);
        }
    }

    @Override
    public void update(User u) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(UPDATE);
            ps.setString(1, u.getFirstName());
            ps.setInt(2, u.getId());
            if (ps.executeUpdate() > 0) {
                LOGGER.info("User with ID:" + u.getId() + " was updated successfully");
            }
        } catch (SQLException e) {
            String message = String.format("User with ID: %d was not updated successfully", u.getId());
            LOGGER.error(message);
        } finally {
            assert ps != null;
            ps.close();
            ConnectionPool.getInstance().returnConnection(con);
        }
    }

    @Override
    public void delete(int id) {
        Connection con = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                String message = String.format("User with ID: %d was removed successfully", id);
                LOGGER.info(message);
            }
        } catch (SQLException e) {
            String message = String.format("User with ID: %d was not removed", id);
            LOGGER.error(message);
        } finally {
            ConnectionPool.getInstance().returnConnection(con);
        }
    }

    public List<User> getAllUsers() {
        Connection con = ConnectionPool.getInstance().getConnection();
        List<User> userList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(READALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                User user = new User(id, firstName, lastName, email);
                userList.add(user);
            }
        } catch (SQLException e) {
            LOGGER.error("Getting all records from User table failed");
        } finally {
            ConnectionPool.getInstance().returnConnection(con);
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return userList;
    }
}
