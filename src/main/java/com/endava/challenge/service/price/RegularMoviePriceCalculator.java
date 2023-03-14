package com.endava.challenge.service.price;

import com.endava.challenge.model.Rental;

public class RegularMoviePriceCalculator implements MoviePriceCalculator {

    @Override
    public double getAmount(Rental rental, double amount) {
        amount += 2;
        if (rental.getDaysRented() > 2) {
            amount += (rental.getDaysRented() - 2) * 1.5;
        }
        return amount;
    }
}
