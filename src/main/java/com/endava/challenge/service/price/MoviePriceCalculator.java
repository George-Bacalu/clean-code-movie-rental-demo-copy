package com.endava.challenge.service.price;

import com.endava.challenge.model.Rental;

public interface MoviePriceCalculator {

    double getAmount(Rental rental, double amount);
}
