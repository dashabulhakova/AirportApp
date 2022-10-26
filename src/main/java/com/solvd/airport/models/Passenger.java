package com.solvd.airport.models;

public class Passenger {
    private int id;
    private int memberId;
    private int animalId;
    private int bagId;
    private int mealId;

    public Passenger() {
    }

    public Passenger(int memberId, int animalId, int bagId, int mealId) {
        this.memberId = memberId;
        this.animalId = animalId;
        this.bagId = bagId;
        this.mealId = mealId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public int getBagId() {
        return bagId;
    }

    public void setBagId(int bagId) {
        this.bagId = bagId;
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }
}
