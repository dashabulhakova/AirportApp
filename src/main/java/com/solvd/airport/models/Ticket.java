package com.solvd.airport.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Ticket {
    @JsonProperty
    private int id;
    @JsonProperty
    private int price;
    @JsonProperty
    private int seat;
    @JsonProperty
    private Date flightDate;

    public Ticket() {
    }

    public Ticket(int price, int seat, Date flightDate) {
        this.price = price;
        this.seat = seat;
        this.flightDate = flightDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }
}
