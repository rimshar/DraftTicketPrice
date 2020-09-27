package com.proofit.techtask.service;

import com.proofit.techtask.config.ExtAPIService;
import com.proofit.techtask.model.DraftTicketPrice;
import com.proofit.techtask.model.Passenger;
import com.proofit.techtask.model.PassengerCategory;
import com.proofit.techtask.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Service
public class DraftPriceService {

    private ExtAPIService extAPIService;

    @Autowired
    public DraftPriceService(ExtAPIService extAPIService) {
        this.extAPIService = extAPIService;
    }

    public DraftTicketPrice getPrice(List<Passenger> passengerList) {
        BigDecimal totalPrice = BigDecimal.valueOf(0);
        List<Ticket> tickets = new ArrayList<>();
        double vat = extAPIService.getVAT();
        Currency currency = Currency.getInstance("EUR");

        for (Passenger passenger : passengerList) {
            String destination = passenger.getBusTerminal();
            int bags = passenger.getBagCount();
            PassengerCategory category = passenger.getCategory();

            BigDecimal basePrice;
            BigDecimal bagPrice;

            if (category == PassengerCategory.INFANT) {
                basePrice = BigDecimal.valueOf(extAPIService.getBasePrice(destination) * 0.5);
            } else {
                basePrice = BigDecimal.valueOf(extAPIService.getBasePrice(destination));
            }

            bagPrice = calculatePriceWithVAT(basePrice.multiply(BigDecimal.valueOf(bags * 0.3)), vat);
            bagPrice = bagPrice.setScale(2, RoundingMode.HALF_EVEN);

            basePrice = calculatePriceWithVAT(basePrice, vat);
            basePrice = basePrice.setScale(2, RoundingMode.HALF_EVEN);

            totalPrice = totalPrice.add(basePrice.add(bagPrice));

            Ticket ticket = new Ticket();
            ticket.setCategory(passenger.getCategory());
            ticket.setBasePrice(basePrice, currency);
            ticket.setBagCount(bags);
            ticket.setTotalBagPrice(bagPrice, currency);
            tickets.add(ticket);
        }

        DraftTicketPrice draftTicketPrice = new DraftTicketPrice();
        draftTicketPrice.setTotalPrice(totalPrice, currency);
        draftTicketPrice.setTickets(tickets);

        return draftTicketPrice;
    }

    public BigDecimal calculatePriceWithVAT(BigDecimal priceWithoutVAT, double vat) {
        return priceWithoutVAT.add(priceWithoutVAT.multiply(BigDecimal.valueOf(vat)));
    }
}
