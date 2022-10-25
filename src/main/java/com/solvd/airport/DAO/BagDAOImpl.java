package com.solvd.airport.DAO;

import com.solvd.airport.models.Bag;
import com.solvd.airport.utils.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BagDAOImpl implements IBagDAO{
    private static final Logger LOGGER = Logger.getLogger(BagDAOImpl.class.getName());
    private static final String READ = "SELECT * FROM bags where id = ?";
    private static final String READALL = "SELECT * FROM discounts";
    private static final String GET_ID_BY_BAG = "SELECT * FROM bags WHERE amount = ? AND size = ? AND weight = ?";
    private static final String INSERT = "INSERT INTO bags (id, amount, size, weight) VALUES (?, ?, ?, ?);";
    private static final String UPDATE = "UPDATE bags SET  amount = ?, size = ?, weight = ?, WHERE id = ?;";
    private static final String DELETE = "DElETE FROM bags WHERE id = ?";


    public Bag getById(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(READ);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Bag b = new Bag();
                b.setAmount(rs.getInt("amount"));
                b.setSize(rs.getInt("size"));
                b.setWeight(rs.getInt("weight"));
                b.setId(id);
                return b;
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert rs != null;
            rs.close();
            ps.close();
            ConnectionPool.getInstance().returnConnection(c);
        }
        throw new SQLException("No data matching the ID given");
    }
    public List<Bag> getAllDiscounts() throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Bag> bags = new ArrayList<>();
        try {
            ps = c.prepareStatement(READALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Bag bag = new Bag(rs.getInt("amount"), rs.getInt("size"), rs.getInt("weight"));
                bag.setId(rs.getInt("id"));
                bags.add(bag);
            }
            return bags;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert rs != null;
            rs.close();
            ps.close();
            ConnectionPool.getInstance().returnConnection(c);
        }
        throw new SQLException("No bags matching the User given");
    }
    @Override
    public List<Bag> getBagByUser(int userID) throws SQLException {
        return null;
    }
    /*public int getIDbyObject(Bag b) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(GET_ID_BY_BAG);
            ps.setInt(1, b.getAmount());
            ps.setInt(2, b.getSize());
            ps.setInt(3, b.setWeight());
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert rs != null;
            rs.close();
            ps.close();
            ConnectionPool.getInstance().returnConnection(c);
        }
        throw new SQLException("No data matching the Object given");
    }
     */
    public void create(Bag b) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(INSERT);
            ps.setInt(1, b.getId());
            ps.setInt(2, b.getAmount());
            ps.setInt(3, b.getSize());
            ps.setInt(4, b.getWeight());
            ps.executeUpdate();
            //return getIDbyObject(b);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            assert ps != null;
            ps.close();
            ConnectionPool.getInstance().returnConnection(c);
        }
        throw new SQLException("Could not get ID of newly created object");
    }

    @Override
    public void update(Bag b) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }
}
