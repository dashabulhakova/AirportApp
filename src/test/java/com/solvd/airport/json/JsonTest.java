package com.solvd.airport.json;

import com.solvd.airport.models.Meal;
import com.solvd.airport.utils.JsonMapper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class JsonTest {
    protected JsonMapper jsonMapper = new JsonMapper();
    protected final String READ_PATH = "src/main/resources/json/meals.json";
    protected final String WRITE_PATH = "src/main/resources/json/new-meal.json";
    protected List<Meal> expectedMealList = List.of(new Meal(1, "4", 127), new Meal(2, "15", 643 ));
    @Test
    public void testReadJSON() {
        List<Meal> mealList = jsonMapper.readJSON(READ_PATH, Meal.class);
        Assert.assertEquals(mealList, expectedMealList, "Meal from JSON matches expected");
    }

    @Test
    void testWriteJSON() {
        jsonMapper.writeJSON(expectedMealList, WRITE_PATH);
        List<Meal> mealList = jsonMapper.readJSON(WRITE_PATH, Meal.class);
        Assert.assertEquals(mealList, expectedMealList, "Meal written to JSON matches expected");
    }
}
