package com.endava.challenge.service.price;

import com.endava.challenge.model.Rental;

public class NewReleaseMoviePriceCalculator implements MoviePriceCalculator {
    @Override
    public double getAmount(Rental rental, double amount) {
        amount += rental.getDaysRented() * 3;
        return amount;
    }
}
