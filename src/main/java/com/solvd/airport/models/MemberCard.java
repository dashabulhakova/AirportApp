package com.solvd.airport.models;

public class MemberCard {
    private int id;
    private String level;
    private int yearsAsMember;
    private double discount;

    public MemberCard() {
    }

    public MemberCard(String level, int yearsAsMember, double discount) {
        this.level = level;
        this.yearsAsMember = yearsAsMember;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getYearsAsMember() {
        return yearsAsMember;
    }

    public void setYearsAsMember(int yearsAsMember) {
        this.yearsAsMember = yearsAsMember;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
