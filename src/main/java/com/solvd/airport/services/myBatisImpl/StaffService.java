package com.solvd.airport.services.myBatisImpl;

import com.solvd.airport.DAO.IStaffDAO;
import com.solvd.airport.DAO.StaffDAOImpl;
import com.solvd.airport.models.Staff;
import com.solvd.airport.services.IStaffService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class StaffService implements IStaffService {
    private StaffDAOImpl staffDAO = new StaffDAOImpl();
    private static final Logger LOGGER = Logger.getLogger(StaffService.class.getName());
    private final SqlSessionFactory sessionFactory = MyBatisFactory.getSessionFactory();

    @Override
    public Staff getStaffByID(int id) {
        try (SqlSession session = sessionFactory.openSession()) {
            IStaffDAO staffDAO = session.getMapper(IStaffDAO.class);
            Staff staff = staffDAO.getById(id);
            if (staff == null) {
                LOGGER.error("User with id " + id + " wasn't found!");
            }
            return staff;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createStaff(Staff s) {
        try (SqlSession session = sessionFactory.openSession()) {
            IStaffDAO staffDAO = session.getMapper(IStaffDAO.class);
            try {
                staffDAO.create(s);
                session.commit();
                LOGGER.info("Created successfully");
            } catch (Exception e) {
                LOGGER.error("Creating wasn't successful", e);
                session.rollback();
            }
        }
    }

    @Override
    public void updateStaff(Staff s) {
        try (SqlSession session = sessionFactory.openSession()) {
            IStaffDAO staffDAO = session.getMapper(IStaffDAO.class);
            try {
                staffDAO.update(s);
                session.commit();
                LOGGER.info("Updated Successfully");
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e);
                session.rollback();
            }
        }
    }

    @Override
    public void deleteStaff(int id) {
        try (SqlSession session = sessionFactory.openSession()) {
            IStaffDAO staffDAO = session.getMapper(IStaffDAO.class);
            try {
                staffDAO.delete(id);
                session.commit();
                LOGGER.info("Staff was removed");
            } catch (Exception e) {
                LOGGER.error("Removing id " + id, e);
                session.rollback();
            }
        }
    }
    @Override
    public List<Staff> getAllStaff() {
        List<Staff> staffList = null;
        staffList = staffDAO.getAllStaff();
        return staffList;
    }
}
