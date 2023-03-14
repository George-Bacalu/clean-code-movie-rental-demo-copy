package com.endava.challenge.service;

import com.endava.challenge.model.Rental;
import java.util.Optional;

public interface CustomerService {

    Optional<Double> getTotalAmount(String customerName);

    Double getAmount(Rental rental, Double amount);
}
