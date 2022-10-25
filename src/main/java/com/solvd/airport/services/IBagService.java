package com.solvd.airport.services;

import com.solvd.airport.models.Bag;

import java.util.List;

public interface IBagService {
    public void createBag(Bag b);

    public List<Bag> getBagsByUser(int userID);

    public List<Bag> parseFromXmlDOM(String schemaName, String XmlName);

    public void parseFromXmlJAXB(String schemaName, String XmlName);
}
