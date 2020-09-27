package com.proofit.techtask.model;

import java.math.BigDecimal;
import java.util.Currency;

public class Ticket {
    private PassengerCategory category;
    private String basePrice;
    private int bagCount;
    private String totalBagPrice;

    public PassengerCategory getCategory() {
        return category;
    }

    public void setCategory(PassengerCategory category) {
        this.category = category;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal price, Currency currency) {
        this.basePrice = price + " " + currency;
    }

    public int getBagCount() {
        return bagCount;
    }

    public void setBagCount(int bagCount) {
        this.bagCount = bagCount;
    }

    public String getTotalBagPrice() {
        return totalBagPrice;
    }

    public void setTotalBagPrice(BigDecimal price, Currency currency) {
        this.totalBagPrice = price + " " + currency;
    }

}
