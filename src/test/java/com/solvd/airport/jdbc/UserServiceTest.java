package com.solvd.airport.jdbc;

import com.solvd.airport.Main;
import com.solvd.airport.models.Staff;
import com.solvd.airport.models.User;
import com.solvd.airport.services.jdbcImpl.UserService;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class UserServiceTest {
        private UserService userService;
        private User user;

        @BeforeClass
        public void setUp() {
            userService = new com.solvd.airport.services.jdbcImpl.UserService();
            user = new User(2, "Jane", "Doe", "Jane@mail.com");
        }

        @Test
        public void testCreateUser() {
            List<User> users = userService.getAllUsers();
            int numUsers = users.size();
            userService.createUser(user);
            Assert.assertEquals(userService.getAllUsers().size(), numUsers + 1);
            System.out.println("I created a user");
        }

        @Test(priority = 1)
        public void testGetUserById() {
            User createu = userService.getUserByID(2);
            Assert.assertEquals(createu, user);
            System.out.println("Got user by id");
        }

        @Test(priority = 2)
        public void testUpdateUser() {
            User updateu = userService.getUserByID(2);
            userService.updateUser(updateu);
            User u = userService.getUserByID(2);
            Assert.assertEquals(u, updateu);
            System.out.println("update usr");
        }

        @AfterSuite
        public void destroy() {
            userService.deleteUser(2);
        }
}
