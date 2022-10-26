package com.solvd.airport.models;

public class FlightClass {
    private int id;
    private String classType;
    private int price_rate;

    public FlightClass() {
    }

    public FlightClass(String classType, int price_rate) {
        this.classType = classType;
        this.price_rate = price_rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public int getPrice_rate() {
        return price_rate;
    }

    public void setPrice_rate(int price_rate) {
        this.price_rate = price_rate;
    }
}
