package com.solvd.airport.services.jdbcImpl;

import com.solvd.airport.DAO.UserDAOImpl;
import com.solvd.airport.models.User;
import com.solvd.airport.services.IUserService;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    private static final Logger LOGGER = Logger.getLogger(UserService.class.getName());
        private UserDAOImpl userDAO = new UserDAOImpl();

        @Override
        public User getUserByID(int id) {
            try {
                return userDAO.getById(id);
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
                return null;
            }
        }

        @Override
        public void createUser(User u) {
            userDAO.create(u);
        }
        @Override
        public void updateUser(User u) {
            try {
                userDAO.update(u);
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
        }
        @Override
        public void deleteUser(int id) {
            userDAO.delete(id);
        }
        @Override
        public List<User> getAllUsers() {
            List<User> usersList = null;
            usersList = userDAO.getAllUsers();
            return usersList;
        }

    }
