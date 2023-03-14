package com.endava.challenge.service;

import java.util.Optional;

public interface RenterPointsCalculatorService {

    Optional<Integer> getTotalFrequentRenterPoints(String customerName);
}
