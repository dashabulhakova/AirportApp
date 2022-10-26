package com.solvd.airport.models;

public class Airline {
    private int id;
    private int index;
    private String name;
    private double fare;

    public Airline() {
    }

    public Airline(int index, String name, double fare) {
        this.index = index;
        this.name = name;
        this.fare = fare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}
