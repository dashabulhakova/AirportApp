package com.solvd.airport.services;

public interface IMealService {
    public void getMealFromXML(String xmlFile, String xsdFile);

    public void createXML(String xmlFile);
}
