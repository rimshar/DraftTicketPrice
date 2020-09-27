package com.proofit.techtask.controller;

import com.proofit.techtask.model.DraftTicketPrice;
import com.proofit.techtask.model.Passenger;
import com.proofit.techtask.service.DraftPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DraftPriceController {
    private DraftPriceService draftPriceService;

    @Autowired
    public DraftPriceController(DraftPriceService draftPriceService) {
        this.draftPriceService = draftPriceService;
    }

    @GetMapping(path = "/getPrice", consumes = "application/json")
    public DraftTicketPrice getPrice(@Valid @RequestBody List<Passenger> passengerList) {
        return draftPriceService.getPrice(passengerList);
    }
}
