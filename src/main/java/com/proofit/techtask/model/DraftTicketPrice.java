package com.proofit.techtask.model;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

public class DraftTicketPrice {
    private String totalPrice;
    private List<Ticket> tickets;

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal price, Currency currency) {
        this.totalPrice = price + " " + currency;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
