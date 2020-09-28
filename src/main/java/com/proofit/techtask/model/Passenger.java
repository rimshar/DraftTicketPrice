package com.proofit.techtask.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Passenger {

    private PassengerCategory category;
    private String destination;
    private int bagCount;

    public PassengerCategory getCategory() {
        return category;
    }

    public void setCategory(PassengerCategory category) {
        this.category = category;
    }

    public int getBagCount() {
        return bagCount;
    }

    public void setBagCount(int bagCount) {
        this.bagCount = bagCount;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
