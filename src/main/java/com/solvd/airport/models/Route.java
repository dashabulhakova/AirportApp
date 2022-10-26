package com.solvd.airport.models;

public class Route {
    private int id;
    private String origin;
    private String destination;
    private static boolean connecting = false;

    public Route() {
    }

    public Route(int id, String origin, String destination) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
    }

    public int getRouteId() {
        return id;
    }

    public void setRouteId(int routeId) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public static boolean isConnecting() {
        return connecting;
    }

    public static void setConnecting(boolean connecting) {
        Route.connecting = connecting;
    }
}
