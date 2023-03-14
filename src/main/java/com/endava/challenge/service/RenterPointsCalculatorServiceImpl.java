package com.endava.challenge.service;

import com.endava.challenge.exception.ResourceNotFoundException;
import com.endava.challenge.model.Customer;
import com.endava.challenge.model.PriceCode;
import com.endava.challenge.model.Rental;
import com.endava.challenge.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.endava.challenge.constants.Constants.CUSTOMER_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class RenterPointsCalculatorServiceImpl implements RenterPointsCalculatorService {
    private final CustomerRepository customerRepository;

    @Override
    public Optional<Integer> getTotalFrequentRenterPoints(String customerName) {
        Optional<Customer> customer = customerRepository.findByName(customerName);
        if (customer.isEmpty()) {
            throw new ResourceNotFoundException(String.format(CUSTOMER_NOT_FOUND, customerName));
        }
        List<Rental> rentals = customer.get().getRentals();
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints++;
            if (rental.getMovie().getPriceCode() == PriceCode.NEW_RELEASE && rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
        }
        return Optional.of(frequentRenterPoints);
    }
}
