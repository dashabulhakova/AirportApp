package com.solvd.airport.services;

public interface ITicketService {
    public void getTicketFromXML(String xmlFile, String xsdFile);
    public void createXML(String xmlFile);
}
