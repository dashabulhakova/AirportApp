package com.solvd.airport.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "meal")
@XmlType(propOrder = {"id", "mealType", "price"})
@JsonPropertyOrder({"id", "mealType", "price"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Meal {
    @XmlAttribute
    @JsonProperty("id")
    private int id;
    @XmlElement
    @JsonProperty("type")
    private String mealType;
    @XmlElement
    @JsonProperty
    private int price;

    public Meal() {
    }

    public Meal(String mealType, int price) {
        this.mealType = mealType;
        this.price = price;
    }
    public Meal(int id, String mealType, int price) {
        this.id = id;
        this.mealType = mealType;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", mealType='" + mealType + '\'' +
                ", price=" + price +
                '}';
    }

}
