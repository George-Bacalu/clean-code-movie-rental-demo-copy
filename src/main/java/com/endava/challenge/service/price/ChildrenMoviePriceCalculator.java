package com.endava.challenge.service.price;

import com.endava.challenge.model.Rental;

public class ChildrenMoviePriceCalculator implements MoviePriceCalculator {
    @Override
    public double getAmount(Rental rental, double amount) {
        amount += 1.5;
        if (rental.getDaysRented() > 3) {
            amount += (rental.getDaysRented() - 3) * 1.5;
        }
        return amount;
    }
}
