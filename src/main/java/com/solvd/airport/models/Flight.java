package com.solvd.airport.models;

public class Flight {
    private int id;
    private int ticketNum;
    private int airportId;
    private int routeId;
    private int classType;

    public Flight() {
    }

    public Flight(int ticketNum, int airportId, int routeId, int classType) {
        this.ticketNum = ticketNum;
        this.airportId = airportId;
        this.routeId = routeId;
        this.classType = classType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getClassType() {
        return classType;
    }

    public void setClassType(int classType) {
        this.classType = classType;
    }

}
