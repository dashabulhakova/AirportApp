package com.solvd.airport;

import com.solvd.airport.models.Meal;
import com.solvd.airport.models.Staff;
import com.solvd.airport.models.User;
import com.solvd.airport.services.IStaffService;
import com.solvd.airport.services.jdbcImpl.UserService;
import com.solvd.airport.services.json.MealService;
import com.solvd.airport.services.myBatisImpl.StaffService;
import com.solvd.airport.utils.JsonMapper;
import org.apache.log4j.Logger;

import java.util.List;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        UserService userService = new UserService();
        //jdbc implementation
        User newUser = new User(4, "Cara", "Styles", "Lara@email.com");
        //userService.createUser(newUser);
        /*newUser = userService.getUserByID(4);
        LOGGER.info(newUser);
        newUser.setFirstName("Mary");
        userService.updateUser(newUser);
        userService.getUserByID(4);
        userService.getAllUsers();
*/
        //myBatis implementation
        IStaffService staffService = new StaffService();
        Staff newStaff = new Staff(3, "Pilot", 345);
        //staffService.createStaff(newStaff);
        //newStaff = staffService.getStaffByID(1);
        newStaff.setPosition("Worker");
        //staffService.updateStaff(newStaff);
        staffService.deleteStaff(2);
        //LOGGER.info(staffService.getAllStaff());

        //json
        MealService mealService = new MealService();
        JsonMapper jsonMapper = new JsonMapper();
        List<Meal> mealsList = jsonMapper.readJSON("src/main/resources/json/meals.json", Meal.class);
        jsonMapper.writeJSON(mealsList, "src/main/resources/json/new_meal.json");
        //jaxb
        mealService.getMealFromXML("src/main/resources/xml/meals.xml", "src/main/resources/xsd/meals.xsd");
        mealService.createXML("src/main/resources/xml/meals.xml");
    }
}