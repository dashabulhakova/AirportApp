package com.solvd.airport.DAO;

import com.solvd.airport.models.Staff;
import com.solvd.airport.utils.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDAOImpl implements IStaffDAO {
    private static final Logger LOGGER = Logger.getLogger(StaffDAOImpl.class.getName());
    private static final String READ = "SELECT * FROM Staff where id = ?";
    private static final String READALL = "SELECT * FROM Staff";
    private static final String INSERT = "INSERT INTO Staff (id, position, staff_member_id) VALUES (?, ?, ?);";
    private static final String UPDATE = "UPDATE Staff SET  position = ?, staff_member_id = ?, WHERE id = ?;";
    private static final String DELETE = "DElETE FROM Staff WHERE id = ?";
    @Override
    public Staff getById(int id) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareStatement(READ);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                String position = rs.getString("position");
                Integer staffMemberId = rs.getInt("staff_member_id");
                return new Staff(id, position, staffMemberId);
            }
        } catch (SQLException e) {
            String message = String.format("Getting staff with ID:%d wasn't successful", id);
            LOGGER.error(message, e);
        } finally {
            assert rs != null;
            rs.close();
            ps.close();
            ConnectionPool.getInstance().returnConnection(con);
        }
        return null;
    }

    @Override
    public void create(Staff s) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(INSERT);
            ps.setInt(1, s.getId());
            ps.setString(2, s.getPosition());
            ps.setInt(3, s.getStaffMemberId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage() + "Staff was not created");
        } finally {
            ConnectionPool.getInstance().returnConnection(con);
            assert ps != null;
        }
    }

    @Override
    public void update(Staff s) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(UPDATE);
            ps.setInt(1, s.getId());
            ps.setString(2, s.getPosition());
            ps.setInt(3, s.getStaffMemberId());
            if (ps.executeUpdate() > 0) {
                LOGGER.info("Staff with ID:" + s.getId() + " was updated successfully");
            }
        } catch (SQLException e) {
            String message = String.format("Staff with ID:" + s.getId() + " was not updated successfully");
            LOGGER.error(message);
        } finally {
            assert ps != null;
            ps.close();
            ConnectionPool.getInstance().returnConnection(con);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection con = ConnectionPool.getInstance().getConnection();
        try(PreparedStatement ps =con.prepareStatement(DELETE)) {
            ps.setInt(1,id);
            if (ps.executeUpdate()>0) {
                String message = String.format("Staff with ID: %d was removed successfully", id);
                LOGGER.info(message);
            }
        } catch (SQLException e) {
            String message = String.format("Staff with ID: %d was not removed", id);
            LOGGER.error(message);
        } finally {
            ConnectionPool.getInstance().returnConnection(con);
        }
    }

    @Override
    public List<Staff> getAllStaff(){
            Connection con = ConnectionPool.getInstance().getConnection();
            List<Staff> staffList = new ArrayList<>();
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                ps = con.prepareStatement(READALL);
                rs = ps.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String position = rs.getString("position");
                    int staffMemberId = rs.getInt("staff_member_id");
                    Staff staff = new Staff(id, position, staffMemberId);
                    staffList.add(staff);
                }
            } catch (SQLException e) {
                LOGGER.error("Getting all records from Staff table failed");
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
            return staffList;
        }
}
