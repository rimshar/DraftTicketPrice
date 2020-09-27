package com.proofit.techtask.service;

import com.proofit.techtask.config.ExtAPIService;
import com.proofit.techtask.model.Passenger;
import com.proofit.techtask.model.PassengerCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DraftPriceServiceTest {

    @Mock
    ExtAPIService extAPIService;

    @InjectMocks
    DraftPriceService draftPriceService;

    @Test
    @DisplayName("getPrice() with valid input")
    void getPriceValidInput() {

        Passenger testPassenger = new Passenger();
        testPassenger.setBusTerminal("Riga");
        testPassenger.setBagCount(3);
        testPassenger.setCategory(PassengerCategory.ADULT);

        List<Passenger> testList = new ArrayList<>();
        testList.add(testPassenger);

        Mockito.when(extAPIService.getBasePrice(Mockito.anyString())).thenReturn(10.0);
        Mockito.when(extAPIService.getVAT()).thenReturn(0.21);

        assertEquals("22.99 EUR", draftPriceService.getPrice(testList).getTotalPrice());
    }

    @Test
    @DisplayName("VAT calculation")
    void calculatePriceWithVATCorrectResult() {
        BigDecimal expectedResult = BigDecimal.valueOf(12.10);
        expectedResult = expectedResult.setScale(2, RoundingMode.HALF_EVEN);
        assertEquals(expectedResult, draftPriceService.calculatePriceWithVAT(BigDecimal.valueOf(10), 0.21));
    }
}