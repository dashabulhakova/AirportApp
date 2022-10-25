package com.solvd.airport.models;

import java.util.Objects;

public class Staff {
    private int id;
    private String position;
    private int staffMemberId;
    public Staff() {
    }

    public Staff(int id, String position, int staffMemberId) {
        this.id = id;
        this.position = position;
        this.staffMemberId = staffMemberId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getStaffMemberId() {
        return staffMemberId;
    }

    public void setStaffMemberId(int staffMemberId) {
        this.staffMemberId = staffMemberId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Staff)) return false;
        Staff staff = (Staff) o;
        return getId() == staff.getId() && getStaffMemberId() == staff.getStaffMemberId() && Objects.equals(getPosition(), staff.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPosition(), getStaffMemberId());
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", staffMemberId=" + staffMemberId +
                '}';
    }
}
