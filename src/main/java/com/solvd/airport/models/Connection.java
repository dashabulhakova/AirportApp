package com.solvd.airport.models;

public class Connection {
    private int id;
    private String location;
    private int time;

    public Connection() {
    }

    public Connection(String location, int time) {
        this.location = location;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
